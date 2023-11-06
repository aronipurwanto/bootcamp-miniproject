package com.bootcamp.pos.service.impl;

import com.bootcamp.pos.model.entity.AddressesEntity;
import com.bootcamp.pos.model.entity.ProductEntity;
import com.bootcamp.pos.model.response.AddressesResponse;
import com.bootcamp.pos.model.response.ProductResponse;
import com.bootcamp.pos.repository.ProductRepo;
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
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    @Override
    public List<ProductResponse> getAll() {
        return productRepo.findAll().stream().map(ProductResponse::new).collect(Collectors.toList());
    }

    @Override
    public Optional<ProductResponse> getById(String id) {
        ProductEntity result = productRepo.findById(id).orElse(null);
        if(result == null){
            return Optional.empty();
        }
        return Optional.of(new ProductResponse(result));
    }

    @Override
    public Optional<ProductResponse> save(ProductResponse request) {
        if(request == null){
            return Optional.empty();
        }
        ProductEntity entity = new ProductEntity(request);
        try{
            productRepo.save(entity);
            log.info("Save Product to database success");
            return Optional.of(new ProductResponse(entity));
        }catch (Exception e){
            log.error("Save Product to database failed, error: {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<ProductResponse> update(ProductResponse request, String id) {
        ProductEntity entity = productRepo.findById(id).orElse(null);
        if(entity == null){
            log.warn("Product dengan id: {} tidak ada",id);
            return Optional.empty();
        }
        BeanUtils.copyProperties(request,entity);
        try{
            productRepo.save(entity);
            log.info("Update Product to database success");
            return Optional.of(new ProductResponse(entity));
        }catch (Exception e){
            log.error("Update Product to database failed, error: {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<ProductResponse> delete(String id) {
        ProductEntity entity = productRepo.findById(id).orElse(null);
        if(entity == null){
            return Optional.empty();
        }
        try{
            productRepo.delete(entity);
            log.info("Delete Product from database success");
            return Optional.of(new ProductResponse(entity));
        }catch (Exception e){
            log.error("Delete Product from database failed, error: {}",e.getMessage());
            return Optional.empty();
        }
    }
}
