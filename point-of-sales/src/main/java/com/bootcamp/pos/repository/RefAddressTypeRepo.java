package com.bootcamp.pos.repository;

import com.bootcamp.pos.model.entity.RefAddressTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefAddressTypeRepo extends JpaRepository<RefAddressTypeEntity, String> {
}
