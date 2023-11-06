package com.bootcamp.pos.service.impl;

import com.bootcamp.pos.model.entity.CustomerEntity;
import com.bootcamp.pos.model.response.CustomerResponse;
import com.bootcamp.pos.repository.CustomerRepository;
import com.bootcamp.pos.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<CustomerResponse> getAll() {
        return customerRepository.findAll().stream().map(CustomerResponse::new).collect(Collectors.toList());
    }

    @Override
    public Optional<CustomerResponse> getById(String id) {
        CustomerEntity result = this.customerRepository.findById(id).orElse(null);
        if(result == null) {
            return Optional.empty();
        }
        return Optional.of(new CustomerResponse(result));
    }

    @Override
    public Optional<CustomerResponse> save(CustomerResponse request) {
        if (request == null) {
            return Optional.empty();
        }
        CustomerEntity entity = new CustomerEntity(request);
        try {
            customerRepository.save(entity);
            log.info("Save customer to database success");
            return Optional.of(new CustomerResponse(entity));
        } catch (Exception e) {
            log.error("Save customer to database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<CustomerResponse> update(CustomerResponse request, String id) {
        CustomerEntity entity = customerRepository.findById(id).orElse(null);
        if(entity == null){
            log.warn("Customer dengan id : {} tidak ada",id);
            return Optional.empty();
        }
        BeanUtils.copyProperties(request, entity);
        try{
            customerRepository.save(entity);
            log.info("Update customer to database success");
            return Optional.of(new CustomerResponse(entity));
        }catch (Exception e){
            log.error("Update customer to database failed");
            return Optional.empty();
        }
    }

    @Override
    public Optional<CustomerResponse> delete(String id) {
        CustomerEntity entity = customerRepository.findById(id).orElse(null);
        if(entity == null){
            return Optional.empty();
        }
        try{
            customerRepository.delete(entity);
            log.info("Delete customer from database success");
            return Optional.of(new CustomerResponse(entity));
        }catch (Exception e){
            log.error("Delete Customer from database failed, error: {}",e.getMessage());
            return Optional.empty();
        }

    }
}
