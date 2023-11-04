package com.bootcamp.pos.repository;

import com.bootcamp.pos.model.entity.ProductSuppliersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSupplierRepository extends JpaRepository<ProductSuppliersEntity, Long> {
}
