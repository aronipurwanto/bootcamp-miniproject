package com.bootcamp.pos.model.entity;

import com.bootcamp.pos.model.response.SupplierLocationResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_supplier_locations")
public class SupplierLocationsEntity {
    @Id
    @Column(name = "id")
    private String id;
    //---------------Relasi ke refProduct------------//
    @Column(name = "supplier_Code")
    private String supplierId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supplier_Code", insertable = false, updatable = false)
    private SuppliersEntity suppliers;
    //---------------------------//


    //---------------Relasi ke Address------------//
    @Column(name = "address_detail")
    private String addressid;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_detail", insertable = false, updatable = false)
    private AddressesEntity addresses;
    //--------------------------//

    //---------------Relasi ke Cus Address------------//
    @Column(name = "customer_address_date")
    private String cusaddressId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="customer_address_date", insertable = false, updatable = false)
    private CustomerAddressEntity customerAddress;
    //--------------------------//

    @Column(name = "date_to")
    private LocalDate dateTo;

    public SupplierLocationsEntity(SupplierLocationResponse response) {
        BeanUtils.copyProperties(response, this);
        this.id= UUID.randomUUID().toString();
    }
}
