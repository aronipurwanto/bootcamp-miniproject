package com.bootcamp.pos.model.entity;

import com.bootcamp.pos.model.request.CustomerRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "tbl_customer")
public class CustomerEntity {
    @Id
    @Column(name = "customer_id")
    private String id;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_phone")
    private Long customerPhone;

    @Column(name = "cutomer_email")
    private String customerEmail;

    @Column(name = "date_order")
    private LocalDate dateOrder;

    @Column(name = "payment_details")
    private Integer paymentDetails;

    @Column(name = "customer_details")
    private String customerDetails;

    @Column(name = "payment_method")
    private String paymentMethod;

    public CustomerEntity(CustomerRequest request) {
        BeanUtils.copyProperties(request, this);
        this.id = UUID.randomUUID().toString();
    }
}
