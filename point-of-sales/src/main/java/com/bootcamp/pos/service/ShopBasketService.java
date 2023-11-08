package com.bootcamp.pos.service;

import com.bootcamp.pos.model.response.ShopBasketResponse;

import java.util.List;
import java.util.Optional;

public interface ShopBasketService {
    List<ShopBasketResponse> getAll();
    Optional<ShopBasketResponse> getById(String id);
    Optional<ShopBasketResponse> save(ShopBasketResponse request);
    Optional<ShopBasketResponse> update(ShopBasketResponse request, String id);
    Optional<ShopBasketResponse> delete(String id);
}
