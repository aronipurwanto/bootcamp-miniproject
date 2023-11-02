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
public class SupplierLocations {

    @Id
    @TableGenerator(name = "tbl_suppliers_locations_seq",
            table = "tbl_sequence",
            pkColumnName = "sequence_id",
            valueColumnName="sequence_value",
            pkColumnValue = "suppliers_locations_id",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_psuppliers_locations_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "supplier_code")
    private String supplierCode;

    @Column(name = "address_id")
    private String addressId;

    @Column(name = "date_from")
    private Date dateFrom;

    @Column(name = "date_to")
    private Date dateTo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "suppliers_id", insertable = false, updatable = false)
    private SuppliersEntity suppliers;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address", insertable = false, updatable = false)
    private AddressEntity address;
}
