package com.bootcamp.pos.sImpl;

import com.bootcamp.pos.model.entity.ProductTypeEntity;
import com.bootcamp.pos.model.request.ProductTypeModel;
import com.bootcamp.pos.repository.ProductTypeRepository;
import com.bootcamp.pos.service.ProductTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductTypeServiceImpl implements ProductTypeService {
    private final ProductTypeRepository productTypeRepository;
    @Override
    public List<ProductTypeModel> getAll() {
        List<ProductTypeEntity> entity = this.productTypeRepository.findAll();
        if (entity == null){
            return Collections.emptyList();
        }
        return entity.stream()
                .map(ProductTypeModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductTypeModel> getById(String id) {
        ProductTypeEntity entity = this.productTypeRepository.findById(id).orElse(null);
        if (entity == null){
            return Optional.empty();
        }
        return Optional.of(new ProductTypeModel(entity));
    }

    @Override
    public Optional<ProductTypeModel> save(ProductTypeModel request) {
        if (request == null){
            return Optional.empty();
        }
        ProductTypeEntity entity = new ProductTypeEntity(request);
        try {
            this.productTypeRepository.save(entity);
            log.info("Save Product Type to database success");
            return Optional.of(new ProductTypeModel(entity));
        }catch (Exception e){
            log.error("Save Product Type to database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<ProductTypeModel> update(ProductTypeModel request, String id) {
        Optional<ProductTypeEntity> entity = this.productTypeRepository.findById(id);
        if (entity == null)
            return Optional.empty();

        ProductTypeEntity data = entity.get();
        BeanUtils.copyProperties(request, data);
        try {
            this.productTypeRepository.save(data);
            log.info("Update Product Type from database success");
            return Optional.of(new ProductTypeModel(data));
        }catch (Exception e){
            log.error("Update Product Type from database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<ProductTypeModel> delete(String id) {
        ProductTypeEntity entity = this.productTypeRepository.findById(id).orElse(null);
        if (entity == null){
            log.warn("product type with id: {} not found", id);
            return Optional.empty();
        }
        try {
            this.productTypeRepository.delete(entity);
            log.info("Delete Product Type from database succes");
            return Optional.of(new ProductTypeModel(entity));
        }catch (Exception e){
            log.error("Delete Product Type from database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }
}
