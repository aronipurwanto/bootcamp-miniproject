package com.bootcamp.pos.service.impl;

import com.bootcamp.pos.model.entity.CustomerEntity;
import com.bootcamp.pos.model.entity.ProductSuppliersEntity;
import com.bootcamp.pos.model.response.CustomerResponse;
import com.bootcamp.pos.model.response.ProductSuppliersResponse;
import com.bootcamp.pos.repository.ProductSupplierRepo;
import com.bootcamp.pos.service.ProductSupplierService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class ProductSupplierServiceImpl implements ProductSupplierService {
    private final ProductSupplierRepo productSupplierRepo;
    @Override
    public List<ProductSuppliersResponse> getAll() {
        return productSupplierRepo.findAll().stream().map(ProductSuppliersResponse::new).collect(Collectors.toList());
    }

    @Override
    public Optional<ProductSuppliersResponse> getById(String id) {
        ProductSuppliersEntity result = this.productSupplierRepo.findById(id).orElse(null);
        if(result == null) {
            return Optional.empty();
        }
        return Optional.of(new ProductSuppliersResponse(result));
    }

    @Override
    public Optional<ProductSuppliersResponse> save(ProductSuppliersResponse request) {
        if (request == null) {
            return Optional.empty();
        }
        ProductSuppliersEntity entity = new ProductSuppliersEntity(request);
        try {
            productSupplierRepo.save(entity);
            log.info("Save product supplier to database success");
            return Optional.of(new ProductSuppliersResponse(entity));
        } catch (Exception e) {
            log.error("Save  product supplier to database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<ProductSuppliersResponse> update(ProductSuppliersResponse request, String id) {
        ProductSuppliersEntity entity = productSupplierRepo.findById(id).orElse(null);
        if(entity == null){
            log.warn("Product Supplier dengan id : {} tidak ada",id);
            return Optional.empty();
        }
        BeanUtils.copyProperties(request, entity);
        try{
            productSupplierRepo.save(entity);
            log.info("Update product supplier to database success");
            return Optional.of(new ProductSuppliersResponse(entity));
        }catch (Exception e){
            log.error("Update product supplier to database failed");
            return Optional.empty();
        }
    }

    @Override
    public Optional<ProductSuppliersResponse> delete(String id) {
        ProductSuppliersEntity entity = productSupplierRepo.findById(id).orElse(null);
        if(entity == null){
            return Optional.empty();
        }
        try{
            productSupplierRepo.delete(entity);
            log.info("Delete  product supplier from database success");
            return Optional.of(new ProductSuppliersResponse(entity));
        }catch (Exception e){
            log.error("Delete  product supplier from database failed, error: {}",e.getMessage());
            return Optional.empty();
        }
    }
}
