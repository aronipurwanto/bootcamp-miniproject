package com.bootcamp.pos.service;

import com.bootcamp.pos.model.request.ProductTypeModel;

import java.util.List;
import java.util.Optional;

public interface ProductTypeService {
    List<ProductTypeModel> getAll();
    Optional<ProductTypeModel> getById(String id);
    Optional<ProductTypeModel> save(ProductTypeModel request);
    Optional<ProductTypeModel> update(ProductTypeModel request, String id);
    Optional<ProductTypeModel> delete(String id);
}
