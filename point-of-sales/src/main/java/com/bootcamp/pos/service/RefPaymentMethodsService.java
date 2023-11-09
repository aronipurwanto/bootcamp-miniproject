package com.bootcamp.pos.service;

import com.bootcamp.pos.model.request.AddressRequest;
import com.bootcamp.pos.model.request.RefAddressTypesRequest;
import com.bootcamp.pos.model.request.RefPaymentMethodsRequest;

import java.util.List;
import java.util.Optional;

public interface RefPaymentMethodsService {
    List<RefPaymentMethodsRequest> getAll();
    RefPaymentMethodsRequest getById(String id);
    Optional<RefPaymentMethodsRequest> save(RefPaymentMethodsRequest request);
    Optional<RefPaymentMethodsRequest> update(RefPaymentMethodsRequest request, String id);
    Optional<RefPaymentMethodsRequest> delete(String id);
}
