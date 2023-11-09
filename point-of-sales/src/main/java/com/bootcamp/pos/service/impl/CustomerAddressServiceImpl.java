package com.bootcamp.pos.service.impl;

import com.bootcamp.pos.model.request.CustomerAddressRequest;
import com.bootcamp.pos.model.entity.CustomerAddressEntity;
import com.bootcamp.pos.repository.CustomerAddressRepo;
import com.bootcamp.pos.service.CustomerAddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CustomerAddressServiceImpl implements CustomerAddressService {
    private final CustomerAddressRepo customerAddressRepo;

    public CustomerAddressServiceImpl(CustomerAddressRepo customerAddressRepo) {
        this.customerAddressRepo = customerAddressRepo;
    }

    @Override
    public List<CustomerAddressRequest> getAll() {
        return this.customerAddressRepo.findAll().stream().map(CustomerAddressRequest::new).collect(Collectors.toList());
    }

    @Override
    public CustomerAddressRequest getById(String id) {
        if (id == null){
            new CustomerAddressRequest();
        }
        return this.customerAddressRepo.findById(id).map(CustomerAddressRequest::new).orElse(new CustomerAddressRequest());
    }

    @Override
    public Optional<CustomerAddressRequest> save(CustomerAddressRequest request) {
        if (request == null){
            return Optional.empty();
        }
        CustomerAddressEntity entity = new CustomerAddressEntity(request);

        try {
            customerAddressRepo.save(entity);
            log.info("save customerAddress to database successfully");
            return Optional.of(new CustomerAddressRequest(entity));
        }catch (Exception ex){
            log.error("save customerAddress to database failed, error:{}", ex.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<CustomerAddressRequest> update(CustomerAddressRequest request, String id) {
        CustomerAddressEntity entity = customerAddressRepo.findById(id).orElse(null);
        if (entity == null){
            log.warn("customerAddress with id: {}, not fount", id);
            return Optional.empty();
        }
        BeanUtils.copyProperties(request, entity);

        try {
            customerAddressRepo.save(entity);
            log.info("update customerAddress to database successfully");
            return Optional.of(new CustomerAddressRequest(entity));
        }catch (Exception ex){
            log.error("update customerAddress to database failed, error: {}", ex.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<CustomerAddressRequest> delete(String id) {
        CustomerAddressEntity entity = customerAddressRepo.findById(id).orElse(null);
        if (entity == null){
            log.warn("customerAddress with id: {}", id);
            return Optional.empty();
        }
        try {
            customerAddressRepo.delete(entity);
            log.info("delete from database successfully");
            return Optional.of(new CustomerAddressRequest(entity));
        }catch (Exception ex){
            log.error("delete customerAddress from database failed, error: {}", ex.getMessage());
            return Optional.empty();
        }
    }
}
