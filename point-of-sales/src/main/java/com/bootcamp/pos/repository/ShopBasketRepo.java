package com.bootcamp.pos.repository;

import com.bootcamp.pos.model.entity.ShoopingBasketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopBasketRepo extends JpaRepository<ShoopingBasketEntity, String> {
}
