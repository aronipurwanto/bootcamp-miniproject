package com.bootcamp.pos.repository;

import com.bootcamp.pos.model.entity.RefAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefAddressRepository extends JpaRepository<RefAddressEntity, String> {
}
