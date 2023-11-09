package com.bootcamp.pos.model.entity;

import com.bootcamp.pos.model.request.SupplierLocationsModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_supplier_loction")
public class SupplierLocationsEntity {
    @Id
    @Column(name = "supplier_location_id")
    private String id;

    @Column(name = "supplier_code")
    private String supplierCode;

    @Column(name = "supplier_id")
    private String supplierId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supplier_id", insertable = false, updatable = false)
    private SuppliersEntity suppliers;

    @Column(name = "address_id")
    private String addressId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", insertable = false, updatable = false)
    private AddressEntity address;

    @Column(name = "date_from")
    private LocalDate dateFrom;

    @Column(name = "date_to")
    private LocalDate dateTo;

    public SupplierLocationsEntity(SupplierLocationsModel model) {
        BeanUtils.copyProperties(model, this);
        this.id = UUID.randomUUID().toString();
    }
}
