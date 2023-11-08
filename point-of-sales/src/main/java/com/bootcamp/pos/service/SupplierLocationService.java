package com.bootcamp.pos.service;

import com.bootcamp.pos.model.response.SupplierLocationResponse;

import java.util.List;
import java.util.Optional;

public interface SupplierLocationService {
    List<SupplierLocationResponse> getAll();
    Optional<SupplierLocationResponse> getById(String id);
    Optional<SupplierLocationResponse> save(SupplierLocationResponse request);
    Optional<SupplierLocationResponse> update(SupplierLocationResponse request, String id);
    Optional<SupplierLocationResponse> delete(String id);
}
