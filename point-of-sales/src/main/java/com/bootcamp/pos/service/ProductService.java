package com.bootcamp.pos.service;

import com.bootcamp.pos.model.entity.ProductEntity;
import com.bootcamp.pos.model.response.ProductResponse;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductResponse> getAll();

    Optional<ProductResponse> getById(String id);
    Optional<ProductResponse> save(ProductResponse request);
    Optional<ProductResponse> update(ProductResponse request, String id);
    Optional<ProductResponse> delete(String id);
}
