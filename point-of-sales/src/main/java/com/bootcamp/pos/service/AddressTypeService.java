package com.bootcamp.pos.service;

import com.bootcamp.pos.model.request.AddressTypeModel;

import java.util.List;
import java.util.Optional;

public interface AddressTypeService {
    List<AddressTypeModel> getAll();
    Optional<AddressTypeModel> getById(String id);
    Optional<AddressTypeModel> save(AddressTypeModel request);
    Optional<AddressTypeModel> update(AddressTypeModel request, String id);
    Optional<AddressTypeModel> delete(AddressTypeModel id);
}
