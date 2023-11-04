package com.bootcamp.pos.repository;

import com.bootcamp.pos.model.entity.BasketItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketItemRepository extends JpaRepository<BasketItemEntity, Long> {
}
