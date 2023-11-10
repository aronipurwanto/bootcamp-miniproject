package com.bootcamp.pos.service.impl;

import com.bootcamp.pos.model.entity.SupplierEntity;
import com.bootcamp.pos.model.request.SupplierRequest;
import com.bootcamp.pos.repository.SupplierRepository;
import com.bootcamp.pos.service.SupplierService;
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
public class SupplierImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    @Override
    public List<SupplierRequest> getAll() {
        return supplierRepository.findAll().stream()
                .map(SupplierRequest::new)
                .collect(Collectors.toList());
    }

    @Override
    public SupplierRequest getById(String id) {
        if (id == null){
            return null;
        }
        return supplierRepository.findById(id)
                .map(SupplierRequest::new)
                .orElse(null);
    }

    @Override
    public Optional<SupplierRequest> save(SupplierRequest request) {
        if (request == null){
            return Optional.empty();
        }
        SupplierEntity entity = new SupplierEntity(request);
        try {
            supplierRepository.save(entity);
            log.info("Save supplier success");
            return Optional.of(new SupplierRequest());
        }catch (Exception e){
            log.error("Save supplier failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<SupplierRequest> update(SupplierRequest request, String id) {
        SupplierEntity entity = supplierRepository.findById(id).orElse(null);
        if (entity == null){
            return Optional.empty();
        }
        BeanUtils.copyProperties(request, entity);
        try {
            supplierRepository.save(entity);
            log.info("Update supplier success");
            return Optional.of(new SupplierRequest());
        }catch (Exception e){
            log.error("Update supplier failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<SupplierRequest> delete(String id) {
        SupplierEntity entity = supplierRepository.findById(id).orElse(null);
        if (entity == null){
            log.warn("Delete supplier with id not found : {}", id);
            return Optional.empty();
        }
        try {
            supplierRepository.delete(entity);
            log.info("Delete supplier success");
            return Optional.of(new SupplierRequest());
        }catch (Exception e){
            log.error("Delete supplier failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }
}
