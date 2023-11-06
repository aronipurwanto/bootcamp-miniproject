package com.bootcamp.pos.service;

import com.bootcamp.pos.model.response.CustomerResponse;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<CustomerResponse> getAll();

    Optional<CustomerResponse> getById(String id);

    Optional<CustomerResponse> save(CustomerResponse request);

    Optional<CustomerResponse> update(CustomerResponse request, String id);

    Optional<CustomerResponse> delete(String id);
}
