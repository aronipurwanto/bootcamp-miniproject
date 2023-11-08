package com.bootcamp.pos.service.impl;

import com.bootcamp.pos.model.entity.AddressEntity;
import com.bootcamp.pos.model.entity.InventoryLocationsEntity;
import com.bootcamp.pos.model.request.InventoryLocationRequest;
import com.bootcamp.pos.repository.AddressRepository;
import com.bootcamp.pos.repository.InventoryLocationRepository;
import com.bootcamp.pos.service.InventoryLocationService;
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
public class InventoryLocationImpl implements InventoryLocationService {
    private final InventoryLocationRepository inventoryLocationRepository;
    private final AddressRepository addressRepository;
    @Override
    public List<InventoryLocationRequest> getAll() {
        return inventoryLocationRepository.findAll().stream()
                .map(InventoryLocationRequest::new)
                .collect(Collectors.toList());
    }

    @Override
    public InventoryLocationRequest getById(String id) {
        if (id == null){
            return null;
        }

        return inventoryLocationRepository.findById(id)
                .map(InventoryLocationRequest::new)
                .orElse(null);
    }

    @Override
    public Optional<InventoryLocationRequest> save(InventoryLocationRequest request) {
        if (request == null){
            return Optional.empty();
        }

        AddressEntity address = addressRepository.findById(request.getAddressId()).orElse(null);
        if (address == null){
            return Optional.empty();
        }

        InventoryLocationsEntity entity = new InventoryLocationsEntity(request, address);
        try {
            inventoryLocationRepository.save(entity);
            log.info("Save inventory success");
            return Optional.of(new InventoryLocationRequest());
        }catch (Exception e){
            log.error("Save inventory failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<InventoryLocationRequest> update(InventoryLocationRequest request, String id) {
        InventoryLocationsEntity entity = inventoryLocationRepository.findById(id).orElse(null);
        if (entity == null){
            return Optional.empty();
        }

        BeanUtils.copyProperties(request, entity);
        try {
            inventoryLocationRepository.save(entity);
            log.info("Update inventory success");
            return Optional.of(new InventoryLocationRequest());
        }catch (Exception e){
            log.error("Update inventory failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<InventoryLocationRequest> delete(String id) {
        InventoryLocationsEntity entity = inventoryLocationRepository.findById(id).orElse(null);
        if (entity == null){
            return Optional.empty();
        }

        try {
            inventoryLocationRepository.delete(entity);
            log.info("Delete inventory success");
            return Optional.of(new InventoryLocationRequest());
        }catch (Exception e){
            log.error("Delete inventory failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }
}
