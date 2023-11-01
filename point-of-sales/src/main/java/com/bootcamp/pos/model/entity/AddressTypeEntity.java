package com.bootcamp.pos.model.entity;

import jakarta.persistence.*;
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
    @TableGenerator(name = "tbl_address_type_seq",
            table = "tbl_sequence",
            pkColumnName = "sequence_id",
            valueColumnName = "sequence_value",
            pkColumnValue = "address_type_id",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_address_type_seq")
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
