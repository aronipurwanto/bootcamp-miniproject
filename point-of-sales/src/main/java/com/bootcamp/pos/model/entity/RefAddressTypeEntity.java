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
    @TableGenerator(name = "tbl_ref_address_seq",
            table = "tbl_sequence",
            pkColumnName = "sequence_id",
            valueColumnName="sequence_value",
            pkColumnValue = "ref_address_id",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_ref_address_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "address_code_type")
    private String addressCodeType;

    @Column(name = "address_desc_type")
    private String addresDescType;

    @Column(name = "delivery")
    private String delivery;

    @Column(name = "billing")
    private String billing;
}
