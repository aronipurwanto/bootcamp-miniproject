package com.bootcamp.pos.service;

import com.bootcamp.pos.model.request.InventoryLocationRequest;

import java.util.List;
import java.util.Optional;

public interface InventoryLocationService {
    List<InventoryLocationRequest> getAll();
    InventoryLocationRequest getById(String id);
    Optional<InventoryLocationRequest> save(InventoryLocationRequest request);
    Optional<InventoryLocationRequest> update(InventoryLocationRequest request, String id);
    Optional<InventoryLocationRequest> delete(String id);
}
