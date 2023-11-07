package com.bootcamp.pos.repository;

import com.bootcamp.pos.model.entity.RefProductTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefProductTypeRepo extends JpaRepository<RefProductTypeEntity, String> {
}
