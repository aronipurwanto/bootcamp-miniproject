package com.bootcamp.pos.service.serviceImpl;

import com.bootcamp.pos.model.entity.ProductsEntity;
import com.bootcamp.pos.model.request.ProductRequest;
import com.bootcamp.pos.repository.ProductRepo;
import com.bootcamp.pos.service.ProductsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductsServiceImpl implements ProductsService {

    private final ProductRepo productRepo;
    @Override
    public List<ProductRequest> getAll() {
        return this.productRepo.findAll().stream().map(ProductRequest::new).collect(Collectors.toList());
    }

    @Override
    public Optional<ProductRequest> getById(String id) {
        ProductsEntity entity = this.productRepo.findById(id).orElse(null);
        if (entity == null){
            return Optional.empty();
        }

        return Optional.of(new ProductRequest(entity));
    }

    @Override
    public Optional<ProductRequest> save(ProductRequest request) {
        return Optional.empty();
    }

    @Override
    public Optional<ProductRequest> update(ProductRequest request, String id) {
        return Optional.empty();
    }

    @Override
    public Optional<ProductRequest> delete(String id) {
        return Optional.empty();
    }
}
