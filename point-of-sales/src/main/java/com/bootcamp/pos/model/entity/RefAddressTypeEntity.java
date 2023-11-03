package com.bootcamp.pos.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_refaddress")
public class RefAddressTypeEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "address_code_type")
    private Long addressCodeType;

    @Column(name = "address_desc_type")
    private String addressDescType;
}
