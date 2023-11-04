package com.bootcamp.pos.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_address_type")
public class AddressTypeEntity {
    @Id
    @Column(name = "address_id")
    private Long id;

    @Column(name = "address_code")
    private String addressCode;

    @Column(name = "address_description")
    private String addressDesc;

    @Column(name = "billing")
    private String billing;

    @Column(name = "delivery_address")
    private String delivery;
}
