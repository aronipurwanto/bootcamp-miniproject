package com.bootcamp.pos.model.entity;

import jakarta.persistence.*;
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
    @TableGenerator(name = "tbl_suppliers_seq",
            table = "tbl_sequence",
            pkColumnName = "sequence_id",
            valueColumnName="sequence_value",
            pkColumnValue = "suppliers_id",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_suppliers_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "supplier_code")
    private String supplierCode;

    @Column(name = "supplier_name")
    private String supplierName;

    @Column(name = "supplier_address")
    private String supplierAddress;

    @Column(name = "supllier_email")
    private String supplierEmail;

    @Column(name = "supplier_phone")
    private Integer supplierPhone;

    @Column(name = "other_supplier")
    private String otherSupplier;
}
