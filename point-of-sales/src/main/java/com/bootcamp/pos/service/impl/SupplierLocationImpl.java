package com.bootcamp.pos.service.impl;

import com.bootcamp.pos.model.entity.SupplierEntity;
import com.bootcamp.pos.model.entity.SupplierLocationEntity;
import com.bootcamp.pos.model.request.SupplierLocationRequest;
import com.bootcamp.pos.repository.SupplierLocationRepository;
import com.bootcamp.pos.repository.SupplierRepository;
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
public class SupplierLocationImpl implements SupplierLocationService {
    private final SupplierLocationRepository supplierLocationRepository;
    private final SupplierRepository supplierRepository;
    @Override
    public List<SupplierLocationRequest> getAll() {
        return supplierLocationRepository.findAll().stream()
                .map(SupplierLocationRequest::new)
                .collect(Collectors.toList());
    }

    @Override
    public SupplierLocationRequest getById(String id) {
        if (id == null){
            return null;
        }

        return supplierLocationRepository.findById(id)
                .map(SupplierLocationRequest::new)
                .orElse(null);
    }

    @Override
    public Optional<SupplierLocationRequest> save(SupplierLocationRequest request) {
        if (request == null){
            return Optional.empty();
        }

        SupplierEntity supplier = supplierRepository.findById(request.getSupplierId()).orElse(null);
        if (supplier == null){
            return Optional.empty();
        }

        SupplierLocationEntity entity = new SupplierLocationEntity(request, supplier);
        try {
            supplierLocationRepository.save(entity);
            log.info("Save Supplier location success");
            return Optional.of(new SupplierLocationRequest());
        }catch (Exception e){
            log.error("Save supplier location failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<SupplierLocationRequest> update(SupplierLocationRequest request, String id) {
        SupplierLocationEntity entity = supplierLocationRepository.findById(id).orElse(null);
        if (entity == null){
            return Optional.empty();
        }

        BeanUtils.copyProperties(request, entity);
        try {
            supplierLocationRepository.save(entity);
            log.info("Update supplier location success");
            return Optional.of(new SupplierLocationRequest());
        }catch (Exception e){
            log.error("Update supplier location failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<SupplierLocationRequest> delete(String id) {
        SupplierLocationEntity entity = supplierLocationRepository.findById(id).orElse(null);
        if (entity == null){
            log.warn("Delete supplier location with id not found : {}", id);
            return Optional.empty();
        }

        try {
            supplierLocationRepository.delete(entity);
            log.info("Delete supplier location success");
            return Optional.of(new SupplierLocationRequest());
        }catch (Exception e){
            log.error("Delete supplier location failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }
}
