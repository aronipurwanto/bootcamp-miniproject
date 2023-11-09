package com.bootcamp.pos.service.impl;

import com.bootcamp.pos.model.entity.CustomerEntity;
import com.bootcamp.pos.model.request.CustomerRequest;
import com.bootcamp.pos.repository.CustomerRepo;
import com.bootcamp.pos.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepo customerRepo;

    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public List<CustomerRequest> getAll() {
        return this.customerRepo.findAll().stream().map(CustomerRequest::new).collect(Collectors.toList());
    }

    @Override
    public CustomerRequest getById(String id) {
        if (id == null){
            new CustomerRequest();
        }
        return this.customerRepo.findById(id).map(CustomerRequest::new).orElse(new CustomerRequest());
    }

    @Override
    public Optional<CustomerRequest> save(CustomerRequest request) {
        if (request == null){
            return Optional.empty();
        }
        CustomerEntity entity = new CustomerEntity(request);

        try{
            customerRepo.save(entity);
            log.info("save customer to database successfully");
            return Optional.of(new CustomerRequest(entity));
        }catch (Exception ex){
            log.error("save customer to database failed, error:{}", ex.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<CustomerRequest> update(CustomerRequest request, String id) {
        CustomerEntity entity = customerRepo.findById(id).orElse(null);
        if (entity == null){
            log.warn("customer with id: {}, not fount", id);
            return Optional.empty();
        }
        BeanUtils.copyProperties(request, entity);

        try {
            customerRepo.save(entity);
            log.info("update customer to database successfully");
            return Optional.of(new CustomerRequest(entity));
        }catch (Exception ex){
            log.error("update customer to database failed, error: {}", ex.getMessage());
            return Optional.empty();
        }

    }
    @Override
    public Optional<CustomerRequest> delete(String id) {
        CustomerEntity entity = customerRepo.findById(id).orElse(null);
        if (entity == null){
            log.warn("customer with id: {}", id);
            return Optional.empty();
        }
        try {
            customerRepo.delete(entity);
            log.info("delete from database successfully");
            return Optional.of(new CustomerRequest(entity));
        }catch (Exception ex){
            log.error("delete customer from database failed, error: {}", ex.getMessage());
            return Optional.empty();
        }
    }
}
