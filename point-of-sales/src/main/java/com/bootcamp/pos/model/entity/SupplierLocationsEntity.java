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
@Table(name = "tbl_supplier_locations")
public class SupplierLocationsEntity {
    @Id
    @Column(name = "supplier_code")
    private String supplierCode;

    @Column(name = "address_id")
    private String addressId;

    @Column(name = "date_from")
    private String dateFrom;

    @Column(name = "date_to")
    private String dateTo;
}
