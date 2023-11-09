package com.bootcamp.pos.service;

import com.bootcamp.pos.model.request.AddressRequest;
import com.bootcamp.pos.model.request.BasketItemRequest;

import java.util.List;
import java.util.Optional;

public interface BasketItemService {
    List<BasketItemRequest> getAll();
    BasketItemRequest getById(String id);
    Optional<BasketItemRequest> save(BasketItemRequest request);
    Optional<BasketItemRequest> update(BasketItemRequest request, String id);
    Optional<BasketItemRequest> delete(String id);
}
