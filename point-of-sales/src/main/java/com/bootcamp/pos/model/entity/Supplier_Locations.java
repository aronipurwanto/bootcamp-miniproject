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
@Table(name = "tbl_supplier_locations")
public class Supplier_Locations {
    @Id
    @Column(name = "id")
    private Long id;
    //--------Relasi ke SUPPLIERS--------//
    @Column(name = "supplier_code")
    private String supplierCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supplier_code")
    private SuppliersEntity suppliers;
    //----------------//

    //--------Relasi ke Address--------//
    @Column(name = "address_id")
    private Long addressId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private AddressesEntity addresses;
    //----------------//


    @Column(name = "date_form")
    private Date dateFrom;
    @Column(name = "date_to")
    private Date dateTo;
}
