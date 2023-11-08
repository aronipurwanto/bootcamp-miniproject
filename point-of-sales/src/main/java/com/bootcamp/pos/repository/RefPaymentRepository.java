package com.bootcamp.pos.repository;

import com.bootcamp.pos.model.entity.RefPaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefPaymentRepository extends JpaRepository<RefPaymentEntity, String> {
}
