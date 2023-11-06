package com.bootcamp.pos.repository;

import com.bootcamp.pos.model.entity.CustomerAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerAddressRepo extends JpaRepository<CustomerAddressEntity, String> {
}
