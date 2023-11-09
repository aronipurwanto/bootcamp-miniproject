package com.bootcamp.pos.service;

import com.bootcamp.pos.model.request.ProductSuppliersModel;

import java.util.List;
import java.util.Optional;

public interface ProductSuppliersService {
    List<ProductSuppliersModel> getAll();
    Optional<ProductSuppliersModel> getById(String id);
    Optional<ProductSuppliersModel> save(ProductSuppliersModel request);
    Optional<ProductSuppliersModel> update(ProductSuppliersModel request, String id);
    Optional<ProductSuppliersModel> delete(String id);
}
