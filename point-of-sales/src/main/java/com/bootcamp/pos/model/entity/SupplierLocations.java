package com.bootcamp.pos.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "supplier_loction")
public class SupplierLocations {
    @Id
    @TableGenerator(name = "tbl_supplier_location_seq",
            table = "tbl_sequence",
            pkColumnName = "sequence_id",
            valueColumnName = "sequence_value",
            pkColumnValue = "supplier_location_id",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_supplier_location_seq")
    @Column(name = "supplier_location_id")
    private Long supplierLocationId;

    @Column(name = "supplier_code")
    private String supplierCode;

    @Column(name = "supplier_id")
    private Long supplierId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supplier_id", insertable = false, updatable = false)
    private SuppliersEntity suppliersEntity;

    @Column(name = "address_id")
    private Long addressId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", insertable = false,updatable = false)
    private AddressEntity addressEntity;

    @Column(name = "date_form")
    private Date dateForm;

    @Column(name = "date_to")
    private Date dateTo;
}
