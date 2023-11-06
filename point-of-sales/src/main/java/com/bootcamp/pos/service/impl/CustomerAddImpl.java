package com.bootcamp.pos.service.impl;

import com.bootcamp.pos.model.entity.CustomerAddressEntity;
import com.bootcamp.pos.model.request.CustomerAddRequest;
import com.bootcamp.pos.repository.CustomerAddRepository;
import com.bootcamp.pos.service.CustomerAddService;
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
public class CustomerAddImpl implements CustomerAddService {
    private final CustomerAddRepository customerAddRepository;
    @Override
    public List<CustomerAddRequest> getAll() {
        return customerAddRepository.findAll().stream().map(CustomerAddRequest::new).collect(Collectors.toList());
    }

    @Override
    public CustomerAddRequest getById(String id) {
        if (id == null){
            return null;
        }
        return customerAddRepository.findById(id).map(CustomerAddRequest::new).orElse(null);
    }

    @Override
    public Optional<CustomerAddRequest> save(CustomerAddRequest request) {
        if (request == null){
            return Optional.empty();
        }

        CustomerAddressEntity entity = new CustomerAddressEntity(request);
        try {
            customerAddRepository.save(entity);
            log.info("Save customerAdd success");
            return Optional.of(new CustomerAddRequest());
        }catch (Exception e){
            log.error("Save customerAdd failed, error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<CustomerAddRequest> update(CustomerAddRequest request, String id) {
        CustomerAddressEntity entity = customerAddRepository.findById(id).orElse(null);
        if (entity == null){
            return Optional.empty();
        }
        BeanUtils.copyProperties(request, entity);
        try {
            customerAddRepository.save(entity);
            log.info("Update customerAdd success");
            return Optional.of(new CustomerAddRequest());
        }catch (Exception e){
            log.error("Update customerAdd failed, error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<CustomerAddRequest> delete(String id) {
        CustomerAddressEntity entity = customerAddRepository.findById(id).orElse(null);
        if (entity == null){
            return Optional.empty();
        }
        try {
            customerAddRepository.delete(entity);
            log.info("Delete customerAdd success");
            return Optional.of(new CustomerAddRequest());
        }catch (Exception e){
            log.error("Delete customerAdd failed, error : {}", e.getMessage());
            return Optional.empty();
        }
    }
}
