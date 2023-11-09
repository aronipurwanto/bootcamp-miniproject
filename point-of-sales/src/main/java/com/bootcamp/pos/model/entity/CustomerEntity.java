package com.bootcamp.pos.model.entity;

import com.bootcamp.pos.model.request.CustomerRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.PrimaryKey;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_customer")
public class CustomerEntity {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "payment_method_code")
    private String paymentMethodCode;

    @Column(name = "cutomer_name")
    private String customerName;

    @Column(name = "customer_phone")
    private String customerPhone;

    @Column(name = "customer_email")
    private String customerEmail;

    @Column(name = "date_became_customer")
    private String dateBecameCustomer;

    @Column(name = "payment_details")
    private String paymentDetails;

    public CustomerEntity(CustomerRequest request) {
        BeanUtils.copyProperties(request, this);
        this.id = UUID.randomUUID().toString();
    }
}
