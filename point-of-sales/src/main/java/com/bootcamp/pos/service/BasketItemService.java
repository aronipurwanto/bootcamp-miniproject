package com.bootcamp.pos.service;

import com.bootcamp.pos.model.request.BasketItemModel;

import java.util.List;
import java.util.Optional;

public interface BasketItemService {
    List<BasketItemModel> getAll();
    Optional<BasketItemModel> getById(String id);
    Optional<BasketItemModel> save(BasketItemModel request);
    Optional<BasketItemModel> update(BasketItemModel request, String id);
    Optional<BasketItemModel> delete(String id);
}
