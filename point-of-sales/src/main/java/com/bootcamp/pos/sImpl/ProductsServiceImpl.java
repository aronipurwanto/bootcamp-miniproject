package com.bootcamp.pos.sImpl;


import com.bootcamp.pos.model.entity.ProductsEntity;
import com.bootcamp.pos.model.request.ProductsModel;
import com.bootcamp.pos.repository.ProductsRepository;
import com.bootcamp.pos.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductsServiceImpl implements ProductService {
    private final ProductsRepository productsRepository;

    @Override
    public List<ProductsModel> getAll() {
        List<ProductsEntity> result = this.productsRepository.findAll();
        if (result == null) {
            return Collections.emptyList();
        }
        return result.stream().map(ProductsModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductsModel> getById(String id) {
        ProductsEntity result = this.productsRepository.findById(id).orElse(null);
        if (result == null) {
            return Optional.empty();
        }

        return Optional.of(new ProductsModel(result));
    }

    @Override
    public Optional<ProductsModel> save(ProductsModel request) {
        if (request == null) {
            return Optional.empty();
        }

        ProductsEntity entity = new ProductsEntity(request);
        try {
            this.productsRepository.save(entity);
            log.info("Save data customer to database success");
            return Optional.of(new ProductsModel(entity));
        } catch (Exception er) {
            log.warn("Save data customer failed, error: {}", er.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<ProductsModel> update(ProductsModel request, String id) {
        Optional<ProductsEntity> entity = this.productsRepository.findById(id);
        if (entity.isEmpty())
            return Optional.empty();

        ProductsEntity data = entity.get();
        BeanUtils.copyProperties(request, data);
        try {
            this.productsRepository.save(data);
            log.info("Update product to database success");
            return Optional.of(new ProductsModel(data));
        } catch (Exception e) {
            log.error("Update product to database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<ProductsModel> delete(String id) {
        ProductsEntity result = this.productsRepository.findById(id).orElse(null);
        if (result == null) {
            log.warn("customer with id: {} not found", id);
            return Optional.empty();
        }
        try {
            this.productsRepository.delete(result);
            log.info("Delete data product from database success");
            return Optional.of(new ProductsModel(result));
        } catch (Exception er) {
            log.error("Delete data product failed, error: {}", er.getMessage());
            return Optional.empty();
        }
    }
}
