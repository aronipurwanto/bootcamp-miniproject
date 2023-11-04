package com.bootcamp.pos.sImpl;

import com.bootcamp.pos.model.entity.CustomerEntity;
import com.bootcamp.pos.model.request.CustomerRequest;
import com.bootcamp.pos.repository.CustomerRepository;
import com.bootcamp.pos.service.CustomerService;
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
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public List<CustomerRequest> getAll() {
        List<CustomerEntity> result = this.customerRepository.findAll();
        if (result == null) {
            return Collections.emptyList();
        }
        return result.stream().map(CustomerRequest::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CustomerRequest> getById(String id) {
        CustomerEntity result = this.customerRepository.findById(id).orElse(null);
        if (result == null) {
            return Optional.empty();
        }

        return Optional.of(new CustomerRequest(result));
    }

    @Override
    public Optional<CustomerRequest> save(CustomerRequest request) {
        if (request == null) {
            return Optional.empty();
        }

        CustomerEntity entity = new CustomerEntity(request);
        try {
            this.customerRepository.save(entity);
            log.info("Save data customer to database success");
            return Optional.of(new CustomerRequest(entity));
        } catch (Exception er) {
            log.warn("Save data customer failed, error: {}", er.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<CustomerRequest> update(CustomerRequest request, String id) {
        Optional<CustomerEntity> entity = this.customerRepository.findById(id);
        if (entity.isEmpty())
            return Optional.empty();

        CustomerEntity data = entity.get();
        BeanUtils.copyProperties(request, data);
        try {
            this.customerRepository.save(data);
            log.info("Update customer to database success");
            return Optional.of(new CustomerRequest(data));
        } catch (Exception e) {
            log.error("Update customer to database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<CustomerRequest> delete(String id) {
        CustomerEntity result = this.customerRepository.findById(id).orElse(null);
        if (result == null) {
            log.warn("customer with id: {} not found", id);
            return Optional.empty();
        }
        try {
            this.customerRepository.delete(result);
            log.info("Delete data fakultas from database success");
            return Optional.of(new CustomerRequest(result));
        } catch (Exception er) {
            log.error("Delete data fakultas failed, error: {}", er.getMessage());
            return Optional.empty();
        }
    }
}
