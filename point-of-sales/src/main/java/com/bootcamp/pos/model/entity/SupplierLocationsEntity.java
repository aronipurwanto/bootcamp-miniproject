package com.bootcamp.pos.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "supplier_loction")
public class SupplierLocationsEntity {
    @Id
    @Column(name = "supplier_location_id")
    private Long supplierLocationId;

    @Column(name = "supplier_code")
    private String supplierCode;

    @Column(name = "supplier_id")
    private Long supplierId;

    @Column(name = "address_id")
    private Long addressId;


    @Column(name = "date_form")
    private Date dateForm;

    @Column(name = "date_to")
    private Date dateTo;
}
