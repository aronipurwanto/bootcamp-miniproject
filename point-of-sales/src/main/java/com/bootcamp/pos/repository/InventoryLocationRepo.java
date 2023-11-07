package com.bootcamp.pos.repository;

import com.bootcamp.pos.model.entity.InventoryLocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryLocationRepo extends JpaRepository<InventoryLocationEntity, String> {
}
