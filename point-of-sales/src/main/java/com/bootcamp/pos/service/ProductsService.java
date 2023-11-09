package com.bootcamp.pos.service;

import com.bootcamp.pos.model.request.ProductsModel;

import java.util.List;
import java.util.Optional;

public interface ProductsService {
    List<ProductsModel> getAll();
    Optional<ProductsModel> getById(String id);
    Optional<ProductsModel> save(ProductsModel request);
    Optional<ProductsModel> update(ProductsModel request, String id);
    Optional<ProductsModel> delete(String id);
}
