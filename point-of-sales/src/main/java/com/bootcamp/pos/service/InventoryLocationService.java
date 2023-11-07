package com.bootcamp.pos.service;

import com.bootcamp.pos.model.response.InventoryLocationResponse;

import java.util.List;
import java.util.Optional;

public interface InventoryLocationService {
    List<InventoryLocationResponse> getAll();
    Optional<InventoryLocationResponse> getById(String id);
    Optional<InventoryLocationResponse> save(InventoryLocationResponse request);
    Optional<InventoryLocationResponse> update(InventoryLocationResponse request, String id);
    Optional<InventoryLocationResponse> delete(String id);
}
