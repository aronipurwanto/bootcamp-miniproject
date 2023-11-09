package com.bootcamp.pos.model.entity;

import com.bootcamp.pos.model.request.CustomerAddressModel;
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
@Table(name = "tbl_customer_address")
public class CustomerAddressEntity {
    @Id
    @Column(name = "customer_address_id")
    private String id;

    @Column(name = "date_form")
    private LocalDate dateFrom;

    @Column(name = "date_to")
    private LocalDate dateTo;

    @Column(name = "address_type_id")
    private String addressTypeId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_type_id", insertable = false, updatable = false)
    private AddressTypeEntity addressType;

    @Column(name = "customer_id")
    private String customerId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private CustomerEntity customer;

    @Column(name = "address_id")
    private String addressId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", insertable = false, updatable = false)
    private AddressEntity address;

    public CustomerAddressEntity(CustomerAddressModel model) {
        BeanUtils.copyProperties(model, this);
        this.id = UUID.randomUUID().toString();
    }
}
