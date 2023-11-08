package com.bootcamp.pos.service.serviceImpl;

import com.bootcamp.pos.model.entity.ProductTypeEntity;
import com.bootcamp.pos.model.request.ProductTypeRequest;
import com.bootcamp.pos.repository.AddressRepo;
import com.bootcamp.pos.repository.ProductTypeRepo;
import com.bootcamp.pos.service.AddressService;
import com.bootcamp.pos.service.ProductTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductTypeServiceImpl implements ProductTypeService {

    private final ProductTypeRepo productTypeRepo;
    @Override
    public List<ProductTypeRequest> getAll() {
        return this.productTypeRepo.findAll().stream().map(ProductTypeRequest::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional <ProductTypeRequest> getById(String id) {
        ProductTypeEntity result = this.productTypeRepo.findById(id).orElse(null);
        if (result == null){
            return Optional.empty();
        }

        return Optional.of(new ProductTypeRequest(result));
    }

    @Override
    public Optional<ProductTypeRequest> save(ProductTypeRequest request) {
        if (request == null){
            return Optional.empty();
        }

        ProductTypeEntity result = new ProductTypeEntity(request);

        try {
            this.productTypeRepo.save(result);
            log.info("Save Address To database Success");
            return Optional.of(new ProductTypeRequest(result));
        } catch (Exception e){
            log.error("Save Address to database failed, error{}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<ProductTypeRequest> update(ProductTypeRequest request, String id) {
        ProductTypeEntity entity = this.productTypeRepo.findById(id).orElse(null);
        if (entity == null){
            return Optional.empty();
        }

        BeanUtils.copyProperties(request, entity);
        entity.setId(id);

        try {
            this.productTypeRepo.save(entity);
            log.info("Update Address to database success");
            return Optional.of(new ProductTypeRequest(entity));
        } catch (Exception e){
            log.error("Update Address to database failed, error:{}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<ProductTypeRequest> delete(String id) {
        ProductTypeEntity entity = this.productTypeRepo.findById(id).orElse(null);
        if (entity == null){
            log.warn("Address With id :{}, not Found", id);
            return Optional.empty();
        }

        try {
            this.productTypeRepo.delete(entity);
            log.info("Delete Address from database success");
            return Optional.of(new ProductTypeRequest(entity));
        } catch (Exception e){
            log.info("Delete Address From database failed, error:{}",e.getMessage());
            return Optional.empty();
        }


    }
}
