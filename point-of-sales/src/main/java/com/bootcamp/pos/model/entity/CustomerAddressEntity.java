package com.bootcamp.pos.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_customer_address")
public class CustomerAddressEntity {

    @Id
    @TableGenerator(name = "tbl_customer_address_seq",
            table = "tbl_sequence",
            pkColumnName = "sequence_id",
            valueColumnName="sequence_value",
            pkColumnValue = "customer_address_id",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_customer_address_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Column(name = "address_id",nullable = false)
    private Long addressId;

    @Column(name = "date_from")
    private Date dateFrom;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_code_id", insertable = false, updatable = false)
    private RefAddressTypeEntity addressCodeType;

    @Column(name = "date_to")
    private Date dateTo;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private CustomerEntity customer;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", insertable = false, updatable = false)
    private AddressEntity addressEntity;
}
