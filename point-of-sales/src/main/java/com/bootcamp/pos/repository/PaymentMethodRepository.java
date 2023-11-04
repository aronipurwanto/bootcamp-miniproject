package com.bootcamp.pos.repository;

import com.bootcamp.pos.model.entity.PaymentMetodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMetodsEntity, Long> {
}