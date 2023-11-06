package com.bootcamp.pos.repository;

import com.bootcamp.pos.model.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {
}
