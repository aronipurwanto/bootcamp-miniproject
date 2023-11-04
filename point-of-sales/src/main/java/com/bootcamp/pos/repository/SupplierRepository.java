package com.bootcamp.pos.repository;

import com.bootcamp.pos.model.entity.SuppliersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<SuppliersEntity, Long>{
}
