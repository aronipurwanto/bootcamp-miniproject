package com.bootcamp.pos.service;

import com.bootcamp.pos.model.request.CustomerAddRequest;
import com.bootcamp.pos.model.request.CustomerRequest;

import java.util.List;
import java.util.Optional;

public interface CustomerAddService {
    List<CustomerAddRequest> getAll();
    CustomerAddRequest getById(String id);
    Optional<CustomerAddRequest> save(CustomerAddRequest request);
    Optional<CustomerAddRequest> update(CustomerAddRequest request, String id);
    Optional<CustomerAddRequest> delete(String id);
}
