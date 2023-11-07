package com.bootcamp.pos.service.impl;

import com.bootcamp.pos.model.entity.SuppliersEntity;
import com.bootcamp.pos.model.response.SupllierResponse;
import com.bootcamp.pos.repository.SupllierRepo;
import com.bootcamp.pos.service.SupllierService;
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
public class SupplierServiceImpl implements SupllierService {
    private final SupllierRepo supllierRepo;
    @Override
    public List<SupllierResponse> getAll() {
        return supllierRepo.findAll().stream().map(SupllierResponse::new).collect(Collectors.toList());
    }

    @Override
    public Optional<SupllierResponse> getById(String id) {
        SuppliersEntity result = supllierRepo.findById(id).orElse(null);
        if(result == null){
            return Optional.empty();
        }
        return Optional.of(new SupllierResponse(result));
    }

    @Override
    public Optional<SupllierResponse> save(SupllierResponse request) {
        if(request == null){
            return Optional.empty();
        }
        SuppliersEntity entity = new SuppliersEntity(request);
        try{
            supllierRepo.save(entity);
            log.info("Save Supplier to database success");
            return Optional.of(new SupllierResponse(entity));
        }catch (Exception e){
            log.error("Save Supplier to database failed, error: {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<SupllierResponse> update(SupllierResponse request, String id) {
        SuppliersEntity entity = supllierRepo.findById(id).orElse(null);
        if(entity == null){
            log.warn("Supplier dengan id: {} tidak ada",id);
            return Optional.empty();
        }
        BeanUtils.copyProperties(request, entity);
        try{
            supllierRepo.save(entity);
            log.info("Update Supplier to database success");
            return Optional.of(new SupllierResponse(entity));
        }catch (Exception e){
            log.error("Update Supplier to database failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<SupllierResponse> delete(String id) {
        SuppliersEntity entity = supllierRepo.findById(id).orElse(null);
            if(entity == null){
                return Optional.empty();
            }
            try{
                supllierRepo.delete(entity);
                log.info("Delete Supplier from database success");
                return Optional.of(new SupllierResponse(entity));
            }catch (Exception e){
                log.error("Delete Supplier from database failed, error: {}",e.getMessage());
                return Optional.empty();
            }
    }
}
