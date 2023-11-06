package com.bootcamp.pos.service;

import com.bootcamp.pos.model.response.CustomerAddressResponse;

import java.util.List;
import java.util.Optional;

public interface CustomerAddressService {
    List<CustomerAddressResponse> getAll();
    Optional<CustomerAddressResponse> getById(String id);
    Optional<CustomerAddressResponse> save(CustomerAddressResponse request);
    Optional<CustomerAddressResponse> update(CustomerAddressResponse request, String id);
    Optional<CustomerAddressResponse> delete(String id);
}
