package com.bootcamp.pos.service;

import com.bootcamp.pos.model.response.BasketItemsResponse;

import java.util.List;
import java.util.Optional;

public interface BasketItemService {
    List<BasketItemsResponse> getAll();
    Optional<BasketItemsResponse> getById(String id);
    Optional<BasketItemsResponse> save(BasketItemsResponse request);
    Optional<BasketItemsResponse> update(BasketItemsResponse request, String id);
    Optional<BasketItemsResponse> delete(String id);
}

