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
@Table(name = "tbl_suppliers_locations")
public class SupplierLocationsEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "supplier_code")
    private Long supplierCode;

    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "date_from")
    private Date dateFrom;

    @Column(name = "date_to")
    private Date dateTo;
}
