package com.bootcamp.pos.repository;

import com.bootcamp.pos.model.entity.RefPaymentMethodsEntity;
import com.bootcamp.pos.model.entity.RefProductTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefProductTypeRepo extends JpaRepository<RefProductTypeEntity, String> {
}
