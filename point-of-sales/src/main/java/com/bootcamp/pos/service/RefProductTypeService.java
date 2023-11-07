package com.bootcamp.pos.service;

import com.bootcamp.pos.model.response.RefProductTypeResponse;

import java.util.List;
import java.util.Optional;

public interface RefProductTypeService {
    List<RefProductTypeResponse> getAll();

    Optional<RefProductTypeResponse> getById(String id);
    Optional<RefProductTypeResponse> save(RefProductTypeResponse request);

    Optional<RefProductTypeResponse> update(RefProductTypeResponse request, String id);
    Optional<RefProductTypeResponse> delete(String id);
}
