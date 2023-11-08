package com.bootcamp.pos.service.impl;

import com.bootcamp.pos.model.entity.ShoopingBasketEntity;
import com.bootcamp.pos.model.entity.SupplierLocationsEntity;
import com.bootcamp.pos.model.response.ShopBasketResponse;
import com.bootcamp.pos.model.response.SupplierLocationResponse;
import com.bootcamp.pos.repository.SupplierLocationRepo;
import com.bootcamp.pos.service.SupplierLocationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class SupplierLocationServiceImpl implements SupplierLocationService {
    private final SupplierLocationRepo supplierLocationRepo;
    @Override
    public List<SupplierLocationResponse> getAll() {
        return supplierLocationRepo.findAll().stream().map(SupplierLocationResponse::new).collect(Collectors.toList());
    }

    @Override
    public Optional<SupplierLocationResponse> getById(String id) {
        SupplierLocationsEntity result = supplierLocationRepo.findById(id).orElse(null);
        if(result == null){
            return Optional.empty();
        }
        return Optional.of(new SupplierLocationResponse(result));
    }

    @Override
    public Optional<SupplierLocationResponse> save(SupplierLocationResponse request) {
        if(request == null){
            return Optional.empty();
        }
        SupplierLocationsEntity entity = new SupplierLocationsEntity(request);
        try{
            supplierLocationRepo.save(entity);
            log.info("Save Sup Loc to database success");
            return Optional.of(new SupplierLocationResponse(entity));
        }catch (Exception e){
            log.error("save sup Loc to database failed, error: {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<SupplierLocationResponse> update(SupplierLocationResponse request, String id) {
        SupplierLocationsEntity entity = supplierLocationRepo.findById(id).orElse(null);
        if(entity == null){
            log.warn("Sup Loc dengan Id : {} tidak ada",id);
        }
        BeanUtils.copyProperties(request, entity);
        try{
            supplierLocationRepo.save(entity);
            log.info("Update Sup Loc to database success");
            return Optional.of(new SupplierLocationResponse(entity));
        }catch (Exception e){
            log.error("Update Sup Loc to database failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<SupplierLocationResponse> delete(String id) {
        SupplierLocationsEntity entity = supplierLocationRepo.findById(id).orElse(null);
        if(entity == null){
            return Optional.empty();
        }
        try{
            supplierLocationRepo.delete(entity);
            log.info("delete Sup Loc from database success");
            return Optional.of(new SupplierLocationResponse(entity));
        }catch (Exception e){
            log.error("Delete  Sup Loc from database failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }
}
