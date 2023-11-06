package com.bootcamp.pos.service.impl;

import com.bootcamp.pos.model.entity.RefAddressTypeEntity;
import com.bootcamp.pos.model.response.RefAddressTypeResponse;
import com.bootcamp.pos.repository.RefAddressTypeRepo;
import com.bootcamp.pos.service.RefAddressTypeService;
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
public class RefAddressTypeServiceImpl implements RefAddressTypeService {
    private final RefAddressTypeRepo refAddressTypeRepo;

    @Override
    public List<RefAddressTypeResponse> getAll() {
        return refAddressTypeRepo.findAll().stream().map(RefAddressTypeResponse::new).collect(Collectors.toList());
    }

    @Override
    public Optional<RefAddressTypeResponse> getById(String id) {
        RefAddressTypeEntity result = this.refAddressTypeRepo.findById(id).orElse(null);
        if(result == null) {
            return Optional.empty();
        }
        return Optional.of(new RefAddressTypeResponse(result));
    }

    @Override
    public Optional<RefAddressTypeResponse> save(RefAddressTypeResponse request) {
        if (request == null) {
            return Optional.empty();
        }
        RefAddressTypeEntity entity = new RefAddressTypeEntity(request);
        try {
            refAddressTypeRepo.save(entity);
            log.info("Save customer to database success");
            return Optional.of(new RefAddressTypeResponse(entity));
        } catch (Exception e) {
            log.error("Save customer to database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<RefAddressTypeResponse> update(RefAddressTypeResponse request, String id) {
        RefAddressTypeEntity entity = refAddressTypeRepo.findById(id).orElse(null);
        if(entity == null){
            log.warn("RefAddrs dengan id : {} tidak ada",id);
        }
        BeanUtils.copyProperties(request, entity);
        try{
            refAddressTypeRepo.save(entity);
            log.info("Save RefAddrs to database success");
            return Optional.of(new RefAddressTypeResponse(entity));
        }catch (Exception e){
            log.error("Save RefAddrs to database failed, error: {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<RefAddressTypeResponse> delete(String id) {
        RefAddressTypeEntity entity = refAddressTypeRepo.findById(id).orElse(null);
            if(entity == null){
                return Optional.empty();
            }
            try{
                refAddressTypeRepo.delete(entity);
                log.info("delete RefAddrs from database success");
                return Optional.of(new RefAddressTypeResponse(entity));
            }catch (Exception e){
                log.error("Delete RefAddrs from database failed, error : {}",e.getMessage());
                return Optional.empty();
            }
    }
}
