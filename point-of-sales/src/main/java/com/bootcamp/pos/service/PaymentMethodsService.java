package com.bootcamp.pos.service;

import com.bootcamp.pos.model.request.PaymentMethodsModel;

import java.util.List;
import java.util.Optional;

public interface PaymentMethodsService {
    List<PaymentMethodsModel> getAll();
    Optional<PaymentMethodsModel> getById(String id);
    Optional<PaymentMethodsModel> save(PaymentMethodsModel request);
    Optional<PaymentMethodsModel> update(PaymentMethodsModel request, String id);
    Optional<PaymentMethodsModel> delete(String id);
}
