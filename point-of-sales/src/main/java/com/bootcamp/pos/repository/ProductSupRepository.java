package com.bootcamp.pos.repository;

import com.bootcamp.pos.model.entity.ProductSupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSupRepository extends JpaRepository<ProductSupplierEntity, String> {
}
