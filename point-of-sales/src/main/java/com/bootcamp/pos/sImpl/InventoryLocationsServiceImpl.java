package com.bootcamp.pos.sImpl;

import com.bootcamp.pos.model.entity.InventoryLocationsEntity;
import com.bootcamp.pos.model.request.InventoryLocationsModel;
import com.bootcamp.pos.repository.InventoryLocationRepository;
import com.bootcamp.pos.service.InventoryLocationsService;
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
public class InventoryLocationsServiceImpl implements InventoryLocationsService {
    private final InventoryLocationRepository inventoryLocationRepository;
    @Override
    public List<InventoryLocationsModel> getAll() {
        return this.inventoryLocationRepository.findAll()
                .stream()
                .map(InventoryLocationsModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public InventoryLocationsModel getById(String id) {
        return this.inventoryLocationRepository.findById(id)
                .map(InventoryLocationsModel::new)
                .orElse(null);
    }

    @Override
    public Optional<InventoryLocationsModel> save(InventoryLocationsModel request) {
        if (request == null){
            return Optional.empty();
        }

        InventoryLocationsEntity entity = new InventoryLocationsEntity(request);
        try {
            this.inventoryLocationRepository.save(entity);
            log.info("Save Inventory Loc to database success");
            return Optional.of(new InventoryLocationsModel(entity));
        }catch (Exception e){
            log.error("Save inventory Loc to database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<InventoryLocationsModel> update(InventoryLocationsModel request, String id) {
        InventoryLocationsEntity entity = this.inventoryLocationRepository.findById(id).orElse(null);
        if (entity == null){
            return Optional.empty();
        }
        BeanUtils.copyProperties(request, entity);
        try {
            this.inventoryLocationRepository.save(entity);
            log.info("Update Inventory Loc to database success");
            return Optional.of(new InventoryLocationsModel(entity));
        }catch (Exception e){
            log.error("Update Inventory Loc to database failed, error: {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<InventoryLocationsModel> delete(String id) {
        InventoryLocationsEntity result = this.inventoryLocationRepository.findById(id).orElse(null);
        if (result == null){
            log.warn("Data with id: {} not found", id);
            return Optional.empty();
        }

        try {
            this.inventoryLocationRepository.delete(result);
            log.info("Delete Inventory Loc from database success");
            return Optional.of(new InventoryLocationsModel(result));
        }catch (Exception e){
            log.error("Delete Inventory Loc from database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }
}