package com.bootcamp.pos.repository;

import com.bootcamp.pos.model.entity.SuppliersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupllierRepo extends JpaRepository<SuppliersEntity, String> {
}
