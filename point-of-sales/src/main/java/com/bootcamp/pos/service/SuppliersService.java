package com.bootcamp.pos.service;

import com.bootcamp.pos.model.request.SuppliersModel;

import java.util.List;
import java.util.Optional;

public interface SuppliersService {
    List<SuppliersModel> getAll();
    Optional<SuppliersModel> getById(String id);
    Optional<SuppliersModel> save(SuppliersModel request);
    Optional<SuppliersModel> update(SuppliersModel request, String id);
    Optional<SuppliersModel> delete(String id);
}
