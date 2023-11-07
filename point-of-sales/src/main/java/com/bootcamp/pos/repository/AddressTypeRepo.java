package com.bootcamp.pos.repository;

import com.bootcamp.pos.model.entity.AddressTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressTypeRepo extends JpaRepository<AddressTypeEntity, String> {
}
