package com.bootcamp.pos.sImpl;


import com.bootcamp.pos.model.entity.ProductSuppliersEntity;
import com.bootcamp.pos.model.request.ProductSuppliersModel;
import com.bootcamp.pos.repository.ProductSuppliersRepository;
import com.bootcamp.pos.service.ProductSuppliersService;
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
public class ProductsSuppliersServiceImpl implements ProductSuppliersService {
    private final ProductSuppliersRepository productSuppliersRepository;

    @Override
    public List<ProductSuppliersModel> getAll() {
        List<ProductSuppliersEntity> result = this.productSuppliersRepository.findAll();
        if (result == null) {
            return Collections.emptyList();
        }
        return result.stream().map(ProductSuppliersModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductSuppliersModel> getById(String id) {
        ProductSuppliersEntity result = this.productSuppliersRepository.findById(id).orElse(null);
        if (result == null) {
            return Optional.empty();
        }

        return Optional.of(new ProductSuppliersModel(result));
    }

    @Override
    public Optional<ProductSuppliersModel> save(ProductSuppliersModel request) {
        if (request == null) {
            return Optional.empty();
        }

        ProductSuppliersEntity entity = new ProductSuppliersEntity(request);
        try {
            this.productSuppliersRepository.save(entity);
            log.info("Save data product suppliers to database success");
            return Optional.of(new ProductSuppliersModel(entity));
        } catch (Exception er) {
            log.warn("Save data product suppliers failed, error: {}", er.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<ProductSuppliersModel> update(ProductSuppliersModel request, String id) {
        Optional<ProductSuppliersEntity> entity = this.productSuppliersRepository.findById(id);
        if (entity.isEmpty())
            return Optional.empty();

        ProductSuppliersEntity data = entity.get();
        BeanUtils.copyProperties(request, data);
        try {
            this.productSuppliersRepository.save(data);
            log.info("Update product suppliers to database success");
            return Optional.of(new ProductSuppliersModel(data));
        } catch (Exception e) {
            log.error("Update product suppliers to database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<ProductSuppliersModel> delete(String id) {
        ProductSuppliersEntity result = this.productSuppliersRepository.findById(id).orElse(null);
        if (result == null) {
            log.warn("data product supplier with id: {} not found", id);
            return Optional.empty();
        }
        try {
            this.productSuppliersRepository.delete(result);
            log.info("Delete data product suppliers from database success");
            return Optional.of(new ProductSuppliersModel(result));
        } catch (Exception er) {
            log.error("Delete data product suppliers failed, error: {}", er.getMessage());
            return Optional.empty();
        }
    }
}
