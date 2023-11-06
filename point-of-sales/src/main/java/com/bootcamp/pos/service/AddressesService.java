package com.bootcamp.pos.service;

import com.bootcamp.pos.model.response.AddressesResponse;
import com.bootcamp.pos.model.response.CustomerResponse;

import java.util.List;
import java.util.Optional;

public interface AddressesService {
    List<AddressesResponse> getAll();
    Optional<AddressesResponse> getById(String id);
    Optional<AddressesResponse> save(AddressesResponse request);
    Optional<AddressesResponse> update(AddressesResponse request, String id);
    Optional<AddressesResponse> delete(String id);
}
