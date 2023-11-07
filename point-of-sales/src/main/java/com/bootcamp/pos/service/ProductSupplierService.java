package com.bootcamp.pos.service;

import com.bootcamp.pos.model.entity.ProductSuppliersEntity;
import com.bootcamp.pos.model.response.ProductSuppliersResponse;

import java.util.List;
import java.util.Optional;

public interface ProductSupplierService {
    List<ProductSuppliersResponse> getAll();
    Optional<ProductSuppliersResponse> getById(String id);
    Optional<ProductSuppliersResponse> save(ProductSuppliersResponse request);
    Optional<ProductSuppliersResponse> update(ProductSuppliersResponse request, String id);
    Optional<ProductSuppliersResponse> delete(String id);
}
