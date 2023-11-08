package com.bootcamp.pos.model.entity;

import com.bootcamp.pos.model.response.CustomerAddressResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="tb_customer_address")
public class CustomerAddressEntity {

    @Id
    @Column(name = "id")
    private String id;
    //---------------Relasi ke customer------------//
    @Column(name = "customer_Id")
    private String customerId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id",insertable = false,updatable = false )
    private CustomerEntity customer;
    //---------------------------//


  //---------------Relasi ke address------------//
    @Column(name = "address_id")
    private String addressId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id",insertable = false, updatable = false)
    private AddressesEntity addresses;
    //---------------------------//

    //---------------Relasi ke ref Address Type------------//
    @Column(name = "address_type_code")
    private String addressTypeCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_type_code", insertable = false, updatable = false)
    private RefAddressTypeEntity refAddressType;
    //---------------------------//


    @Column(name = "date_from")
    private LocalDate dateFrom;

    @Column(name = "date_to")
    private LocalDate dateTo;

    public CustomerAddressEntity(CustomerAddressResponse response) {
        BeanUtils.copyProperties(response, this);
        this.id = UUID.randomUUID().toString();
    }
}
