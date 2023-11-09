package com.bootcamp.pos.service;

import com.bootcamp.pos.model.request.SupplierLocationsModel;

import java.util.List;
import java.util.Optional;

public interface SupplierLocationsService {
    List<SupplierLocationsModel> getAll();
    Optional<SupplierLocationsModel> getById(String id);
    Optional<SupplierLocationsModel> save(SupplierLocationsModel request);
    Optional<SupplierLocationsModel> update(SupplierLocationsModel request, String id);
    Optional<SupplierLocationsModel> delete(String id);
}
