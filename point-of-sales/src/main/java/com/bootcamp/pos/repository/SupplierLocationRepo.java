package com.bootcamp.pos.repository;

import com.bootcamp.pos.model.entity.SupplierLocationsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierLocationRepo extends JpaRepository<SupplierLocationsEntity, String> {
}
