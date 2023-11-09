package com.bootcamp.pos.repository;

import com.bootcamp.pos.model.entity.ProductEntity;
import com.bootcamp.pos.model.entity.RefPaymentMethodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefPaymentMethodsRepo extends JpaRepository<RefPaymentMethodsEntity, String> {
}
