package com.bootcamp.pos.service.impl;

import com.bootcamp.pos.model.entity.ProductEntity;
import com.bootcamp.pos.model.entity.RefProductEntity;
import com.bootcamp.pos.model.request.ProductRequest;
import com.bootcamp.pos.repository.ProductRepository;
import com.bootcamp.pos.repository.RefProductRepository;
import com.bootcamp.pos.service.ProductService;
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
public class ProductImpl implements ProductService {
    private final ProductRepository productRepository;
    private final RefProductRepository refProductRepository;
    @Override
    public List<ProductRequest> getAll() {
        return productRepository.findAll().stream().map(ProductRequest::new).collect(Collectors.toList());
    }

    @Override
    public ProductRequest getById(String id) {
        if (id == null){
            return null;
        }
        return productRepository.findById(id).map(ProductRequest::new).orElse(null);
    }

    @Override
    public Optional<ProductRequest> save(ProductRequest request) {
        if (request == null){
            return Optional.empty();
        }

        RefProductEntity refProduct = refProductRepository.findById(request.getRefProductId()).orElse(null);
        if (refProduct == null){
            return Optional.empty();
        }
        ProductEntity entity = new ProductEntity(request, refProduct);
        try {
            productRepository.save(entity);
            log.info("Save Product success");
            return Optional.of(new ProductRequest());
        }catch (Exception e){
            log.error("Save Product failed, error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<ProductRequest> update(ProductRequest request, String id) {
        ProductEntity entity = productRepository.findById(id).orElse(null);
        if (entity == null){
            return Optional.empty();
        }
        BeanUtils.copyProperties(request, entity);
        try {
            productRepository.save(entity);
            log.info("Update product success");
            return Optional.of(new ProductRequest());
        }catch (Exception e){
            log.error("Update product failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<ProductRequest> delete(String id) {
        ProductEntity entity = productRepository.findById(id).orElse(null);
        if (entity == null){
            return Optional.empty();
        }
        try {
            productRepository.delete(entity);
            log.info("Delete product success");
            return Optional.of(new ProductRequest());
        }catch (Exception e){
            log.error("Delete product failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }
}
