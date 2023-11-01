package com.bootcamp.pos.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="tb_customer_address")
public class CustomerAddressEntity {

    //--------Relasi ke Customer--------//
    @Column(name = "customer_id")
    private Long customerId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private CustomerEntity customer;
    //------------------//

    //--------Relasi ke Address--------//
    @Column(name = "address_id")
    private Long addressId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private AddressesEntity addresses;
    //------------------//

    @Id
    @Column(name = "date_form")
    private Date date;


    @Column(name = "address_type_code")
    private String addressTypeCode;


    @Column(name = "date_to")
    private Date dateTo;
}
