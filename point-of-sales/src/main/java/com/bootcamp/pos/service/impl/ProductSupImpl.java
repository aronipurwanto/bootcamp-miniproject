package com.bootcamp.pos.service.impl;

import com.bootcamp.pos.model.entity.ProductEntity;
import com.bootcamp.pos.model.entity.ProductSupplierEntity;
import com.bootcamp.pos.model.request.ProductSupplierRequest;
import com.bootcamp.pos.repository.ProductRepository;
import com.bootcamp.pos.repository.ProductSupRepository;
import com.bootcamp.pos.service.ProductSupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductSupImpl implements ProductSupService {
    private final ProductSupRepository productSupRepository;
    private final ProductRepository productRepository;
    @Override
    public List<ProductSupplierRequest> getAll() {
        return productSupRepository.findAll().stream()
                .map(ProductSupplierRequest::new)
                .collect(Collectors.toList());
    }

    @Override
    public ProductSupplierRequest getById(String id) {
        if (id == null){
            return null;
        }
        return productSupRepository.findById(id)
                .map(ProductSupplierRequest::new)
                .orElse(null);
    }

    @Override
    public Optional<ProductSupplierRequest> save(ProductSupplierRequest request) {
        if (request == null){
            return Optional.empty();
        }

        ProductEntity entity = productRepository.findById(request.getProductId()).orElse(null);
        if (entity == null){
            return Optional.empty();
        }

        ProductSupplierEntity productSupplier = new ProductSupplierEntity(request, entity);
        try {
            productSupRepository.save(productSupplier);
            log.info("Save product supplier success");
            return Optional.of(new ProductSupplierRequest());
        }catch (Exception e){
            log.error("Save product supplier failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<ProductSupplierRequest> update(ProductSupplierRequest request, String id) {
        ProductSupplierEntity entity = productSupRepository.findById(id).orElse(null);
        if (entity == null){
            return Optional.empty();
        }

        BeanUtils.copyProperties(request, entity);
        try {
            productSupRepository.save(entity);
            log.info("Update product supplier success");
            return Optional.of(new ProductSupplierRequest());
        }catch (Exception e){
            log.error("Update product supplier failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<ProductSupplierRequest> delete(String id) {
        ProductSupplierEntity entity = productSupRepository.findById(id).orElse(null);
        if (entity == null){
            return Optional.empty();
        }

        try {
            productSupRepository.delete(entity);
            log.info("Delete product supplier success");
            return Optional.of(new ProductSupplierRequest());
        }catch (Exception e){
            log.error("Delete product supplier failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }
}
