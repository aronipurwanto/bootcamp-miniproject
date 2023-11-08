package com.bootcamp.pos.model.entity;

import com.bootcamp.pos.model.request.CustomerAddRequest;
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
@Table(name = "tbl_customer_address")
public class CustomerAddressEntity {
    @Id
    @Column(name = "customer_addr_id", length = 36)
    private String id;

    @Column(name = "customer_id", length = 36)
    private String customerId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private CustomerEntity customer;

    @Column(name = "address_id", length = 36)
    private String addressId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", insertable = false, updatable = false)
    private AddressEntity address;

    @Column(name = "date_from")
    private LocalDate dateFrom;

    @Column(name = "date_to")
    private LocalDate dateTo;

    @Column(name = "ref_address_id")
    private String refAddressId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ref_address_id", insertable = false, updatable = false)
    private RefAddressEntity refAddress;

    public CustomerAddressEntity(CustomerAddRequest request, RefAddressEntity refAddress) {
        BeanUtils.copyProperties(request, this);
        this.id = UUID.randomUUID().toString();
        this.refAddress = refAddress;
    }
}
