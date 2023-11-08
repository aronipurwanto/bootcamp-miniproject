package com.bootcamp.pos.service;

import com.bootcamp.pos.model.request.RefPaymentRequest;

import java.util.List;
import java.util.Optional;

public interface RefPaymentService {
    List<RefPaymentRequest> getAll();
    RefPaymentRequest getById(String id);
    Optional<RefPaymentRequest> save(RefPaymentRequest request);
    Optional<RefPaymentRequest> update(RefPaymentRequest request, String id);
    Optional<RefPaymentRequest> delete(String id);
}
