package com.bootcamp.pos.service;

import com.bootcamp.pos.model.request.AddressModel;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    List<AddressModel> getAll();
    Optional<AddressModel> getById(String id);
    Optional<AddressModel> save(AddressModel request);
    Optional<AddressModel> update(AddressModel request, String id);
    Optional<AddressModel> delete(String id);
}
