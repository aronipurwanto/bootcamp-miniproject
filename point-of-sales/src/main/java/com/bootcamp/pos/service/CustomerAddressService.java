package com.bootcamp.pos.service;

import com.bootcamp.pos.model.request.CustomerAddressModel;

import java.util.List;
import java.util.Optional;

public interface CustomerAddressService {
    List<CustomerAddressModel> getAll();
    CustomerAddressModel getById(String id);
    Optional<CustomerAddressModel> save(CustomerAddressModel request);
    Optional<CustomerAddressModel> update(CustomerAddressModel request, String id);
    Optional<CustomerAddressModel> delete(String id);
}
