package com.bootcamp.pos.model.entity;

import com.bootcamp.pos.model.request.CustomerAddressRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_customer_address")
public class CustomerAddressEntity {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "date_from")
    private String dateFrom;

    @Column(name = "address_type_code_date_to")
    private String addressTypeCodeDateTo;

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

    public CustomerAddressEntity(CustomerAddressRequest request) {
        BeanUtils.copyProperties(request, this);
        this.id = UUID.randomUUID().toString();
    }
}
