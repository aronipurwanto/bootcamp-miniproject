package com.bootcamp.pos.repository;

import com.bootcamp.pos.model.entity.AddressesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressesRepo extends JpaRepository<AddressesEntity, String> {
}
