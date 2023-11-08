package com.bootcamp.pos.model.entity;

import com.bootcamp.pos.model.request.CustomerRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tbl_customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class  CustomerEntity {
    @Id
    @Column(name = "customer_id", length = 36)
    private String id;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "customer_phone")
    private String phone;

    @Column(name = "customer_email")
    private String email;

    @Column(name = "date_became_customer")
    private LocalDate dateBecame;

    @Column(name = "payment_detail")
    private String paymentDetail;

    @Column(name = "other_customer_detail")
    private String otherCustomerDetail;

    @Column(name = "payment_id", length = 36)
    private String paymentId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "payment_id", insertable = false, updatable = false)
    private RefPaymentEntity payment;

    public CustomerEntity(CustomerRequest request, RefPaymentEntity payment) {
        BeanUtils.copyProperties(request, this);
        this.id = UUID.randomUUID().toString();
        this.payment = payment;
    }
}
