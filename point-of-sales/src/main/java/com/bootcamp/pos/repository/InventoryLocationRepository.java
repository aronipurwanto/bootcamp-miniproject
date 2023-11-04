package com.bootcamp.pos.repository;

import com.bootcamp.pos.model.entity.InventoryLocationsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryLocationRepository extends JpaRepository<InventoryLocationsEntity, Long> {
}
