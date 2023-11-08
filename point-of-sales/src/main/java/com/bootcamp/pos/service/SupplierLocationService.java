package com.bootcamp.pos.service;

import com.bootcamp.pos.model.request.SupplierLocationRequest;

import java.util.List;
import java.util.Optional;

public interface SupplierLocationService {
    List<SupplierLocationRequest> getAll();
    SupplierLocationRequest getById(String id);
    Optional<SupplierLocationRequest> save(SupplierLocationRequest request);
    Optional<SupplierLocationRequest> update(SupplierLocationRequest request, String id);
    Optional<SupplierLocationRequest> delete(String id);
}
