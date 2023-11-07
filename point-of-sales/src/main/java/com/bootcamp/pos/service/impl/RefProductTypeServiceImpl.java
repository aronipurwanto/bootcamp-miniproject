package com.bootcamp.pos.service.impl;

import com.bootcamp.pos.model.entity.RefAddressTypeEntity;
import com.bootcamp.pos.model.entity.RefProductTypeEntity;
import com.bootcamp.pos.model.response.RefAddressTypeResponse;
import com.bootcamp.pos.model.response.RefProductTypeResponse;
import com.bootcamp.pos.repository.RefAddressTypeRepo;
import com.bootcamp.pos.repository.RefProductTypeRepo;
import com.bootcamp.pos.service.RefAddressTypeService;
import com.bootcamp.pos.service.RefProductTypeService;
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
public class RefProductTypeServiceImpl implements RefProductTypeService {
    private final RefProductTypeRepo refProductTypeRepo;
    @Override
    public List<RefProductTypeResponse> getAll() {
        return refProductTypeRepo.findAll().stream().map(RefProductTypeResponse::new).collect(Collectors.toList());
    }

    @Override
    public Optional<RefProductTypeResponse> getById(String id) {
        RefProductTypeEntity result = refProductTypeRepo.findById(id).orElse(null);
        if(result == null){
            return Optional.empty();
        }
        return Optional.of(new RefProductTypeResponse(result));
    }

    @Override
    public Optional<RefProductTypeResponse> save(RefProductTypeResponse request) {
        if(request == null){
            return Optional.empty();
        }
        RefProductTypeEntity entity = new RefProductTypeEntity(request);
        try{
            refProductTypeRepo.save(entity);
            log.info("Save RefProduct to database success");
            return Optional.of(new RefProductTypeResponse(entity));
        }catch (Exception e){
            log.error("Save RefProduct to database success");
            return Optional.empty();
        }
    }

    @Override
    public Optional<RefProductTypeResponse> update(RefProductTypeResponse request, String id) {
        RefProductTypeEntity entity = refProductTypeRepo.findById(id).orElse(null);
        if(entity == null){
            log.warn("RefProduct dengan id : {} tidak ada",id);
        }
        BeanUtils.copyProperties(request, entity);
        try{
            refProductTypeRepo.save(entity);
            log.info("Save RefProduct to database success");
            return Optional.of(new RefProductTypeResponse(entity));
        }catch (Exception e){
            log.error("Save RefProduct to database failed, error: {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<RefProductTypeResponse> delete(String id) {
        RefProductTypeEntity entity = refProductTypeRepo.findById(id).orElse(null);
        if(entity == null){
            return Optional.empty();
        }
        try{
            refProductTypeRepo.delete(entity);
            log.info("delete RefProduct from database success");
            return Optional.of(new RefProductTypeResponse(entity));
        }catch (Exception e){
            log.error("Delete RefAddRefProductrs from database failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }
}
