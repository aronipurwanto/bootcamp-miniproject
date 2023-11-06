package com.bootcamp.pos.service;

import com.bootcamp.pos.model.response.RefAddressTypeResponse;

import java.util.List;
import java.util.Optional;

public interface RefAddressTypeService {
    List<RefAddressTypeResponse> getAll();
    Optional<RefAddressTypeResponse> getById(String id);
    Optional<RefAddressTypeResponse> save(RefAddressTypeResponse request);
    Optional<RefAddressTypeResponse> update(RefAddressTypeResponse request, String id);
    Optional<RefAddressTypeResponse> delete(String id);
}
