package com.bootcamp.pos.repository;

import com.bootcamp.pos.model.entity.SupplierLocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierLocationRepository extends JpaRepository<SupplierLocationEntity, String> {
}
