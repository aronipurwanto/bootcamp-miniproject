package com.bootcamp.pos.service.impl;

import com.bootcamp.pos.model.entity.CustomerEntity;
import com.bootcamp.pos.model.request.CustomerRequest;
import com.bootcamp.pos.repository.CustomerRepository;
import com.bootcamp.pos.service.CustomerService;
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
public class CustomerImpl implements CustomerService {
    private final CustomerRepository customerRepo;
    @Override
    public List<CustomerRequest> getAll() {
        return customerRepo.findAll()
                .stream()
                .map(CustomerRequest::new)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerRequest getById(String id) {
        return customerRepo.findById(id)
                .map(CustomerRequest::new)
                .orElse(null);
    }

    @Override
    public Optional<CustomerRequest> save(CustomerRequest request) {
        if (request == null){
            return Optional.empty();
        }

        CustomerEntity entity = new CustomerEntity(request);
        try {
            customerRepo.save(entity);
            log.info("Save customer success");
            return Optional.of(new CustomerRequest());
        }catch (Exception e){
            log.error("Save customer failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<CustomerRequest> update(CustomerRequest request, String id) {
        CustomerEntity entity = customerRepo.findById(id).orElse(null);
        if (entity == null){
            return Optional.empty();
        }
        BeanUtils.copyProperties(request, entity);
        try {
            customerRepo.save(entity);
            log.info("Update customer success");
            return Optional.of(new CustomerRequest());
        }catch (Exception e){
            log.error("Update customer failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }
    @Override
    public Optional<CustomerRequest> delete(String id) {
        CustomerEntity entity = customerRepo.findById(id).orElse(null);
        if (entity == null){
            return Optional.empty();
        }
        try {
            customerRepo.delete(entity);
            log.info("Delete customer success");
            return Optional.of(new CustomerRequest());
        }catch (Exception e){
            log.error("Delete customer failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }
}
