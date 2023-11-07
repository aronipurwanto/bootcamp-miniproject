package com.bootcamp.pos.service;

import com.bootcamp.pos.model.response.SupllierResponse;

import java.util.List;
import java.util.Optional;

public interface SupllierService {
        List<SupllierResponse> getAll();
        Optional<SupllierResponse> getById(String id);
        Optional<SupllierResponse> save(SupllierResponse request);
        Optional<SupllierResponse> update(SupllierResponse request, String id);
        Optional<SupllierResponse> delete(String id);
}
