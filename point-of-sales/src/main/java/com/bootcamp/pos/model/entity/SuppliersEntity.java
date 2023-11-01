package com.bootcamp.pos.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_suppliers")
public class SuppliersEntity {
    @Id
    @Column(name = "supplier_code")
    private String code;

    @Column(name = "supplier_name")
    private String name;

    @Column(name = "supplier_address")
    private String address;

    @Column(name = "supplier_email")
    private String email;

    @Column(name = "supplier_phone")
    private Integer phone;

    @Column(name = "other_supplier_detail")
    private String supDetails;
}
