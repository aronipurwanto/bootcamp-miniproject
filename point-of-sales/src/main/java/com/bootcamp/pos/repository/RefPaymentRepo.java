package com.bootcamp.pos.repository;

import com.bootcamp.pos.model.entity.RefPaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefPaymentRepo extends JpaRepository<RefPaymentEntity, String> {
}
