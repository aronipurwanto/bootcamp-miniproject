package com.bootcamp.pos.service;

import com.bootcamp.pos.model.request.ProductSupplierRequest;
import com.bootcamp.pos.model.request.RefProductRequest;

import java.util.List;
import java.util.Optional;

public interface RefProductService {
    List<RefProductRequest> getAll();
    RefProductRequest getById(String id);
    Optional<RefProductRequest> save(RefProductRequest request);
    Optional<RefProductRequest> update(RefProductRequest request, String id);
    Optional<RefProductRequest> delete(String id);
}
