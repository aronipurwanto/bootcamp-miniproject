package com.bootcamp.pos.service;

import com.bootcamp.pos.model.request.ShoppingBasketModel;

import java.util.List;
import java.util.Optional;

public interface ShoppingBasketService {
    List<ShoppingBasketModel> getAll();
    Optional<ShoppingBasketModel> getById(String id);
    Optional<ShoppingBasketModel> save(ShoppingBasketModel request);
    Optional<ShoppingBasketModel> update(ShoppingBasketModel request, String id);
    Optional<ShoppingBasketModel> delete(String id);
}
