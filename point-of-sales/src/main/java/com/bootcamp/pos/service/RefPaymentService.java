package com.bootcamp.pos.service;

import com.bootcamp.pos.model.response.RefPaymentResponse;

import java.util.List;
import java.util.Optional;

public interface RefPaymentService {
    List<RefPaymentResponse> getAll();
    Optional<RefPaymentResponse> getById(String id);
    Optional<RefPaymentResponse> save(RefPaymentResponse request);
    Optional<RefPaymentResponse> update(RefPaymentResponse request, String id);
    Optional<RefPaymentResponse> delete(String id);

}
