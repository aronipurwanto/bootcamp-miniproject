package com.bootcamp.pos.service;

import com.bootcamp.pos.model.request.RefAddressRequest;

import java.util.List;
import java.util.Optional;

public interface RefAddressService {
    List<RefAddressRequest> getAll();
    RefAddressRequest getById(String id);
    Optional<RefAddressRequest> save(RefAddressRequest request);
    Optional<RefAddressRequest> update(RefAddressRequest request, String id);
    Optional<RefAddressRequest> delete(String id);
}
