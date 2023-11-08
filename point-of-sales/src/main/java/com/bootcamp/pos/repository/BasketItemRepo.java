package com.bootcamp.pos.repository;

import com.bootcamp.pos.model.entity.BasketItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketItemRepo extends JpaRepository<BasketItemsEntity , String> {
}
