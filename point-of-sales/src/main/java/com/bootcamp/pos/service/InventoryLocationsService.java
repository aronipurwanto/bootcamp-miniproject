package com.bootcamp.pos.service;

import com.bootcamp.pos.model.request.InventoryLocationsModel;

import java.util.List;
import java.util.Optional;

public interface InventoryLocationsService {
    List<InventoryLocationsModel> getAll();
    InventoryLocationsModel getById(String id);
    Optional<InventoryLocationsModel> save(InventoryLocationsModel request);
    Optional<InventoryLocationsModel> update(InventoryLocationsModel request, String id);
    Optional<InventoryLocationsModel> delete(String id);
}
