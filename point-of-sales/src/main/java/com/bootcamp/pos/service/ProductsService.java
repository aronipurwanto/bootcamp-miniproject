package com.bootcamp.pos.service;

import com.bootcamp.pos.model.request.ProductRequest;

import java.util.List;
import java.util.Optional;

public interface ProductsService {
    List<ProductRequest> getAll();
    Optional<ProductRequest> getById(String id);
    Optional<ProductRequest> save(ProductRequest request);
    Optional<ProductRequest> update(ProductRequest request, String id);
    Optional<ProductRequest> delete(String id);
}
