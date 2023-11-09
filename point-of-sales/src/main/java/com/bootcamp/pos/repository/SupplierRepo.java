package com.bootcamp.pos.repository;

import com.bootcamp.pos.model.entity.SupplierEntity;
import com.bootcamp.pos.model.entity.SupplierLocationsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepo extends JpaRepository<SupplierEntity, String> {
}
