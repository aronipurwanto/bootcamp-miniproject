package com.bootcamp.pos.repository;

import com.bootcamp.pos.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<ProductEntity, String> {
}
