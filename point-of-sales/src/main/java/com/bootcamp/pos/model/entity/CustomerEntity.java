package com.bootcamp.pos.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "tbl_customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "customer_phone")
    private Integer phone;

    @Column(name = "customer_email")
    private String email;

    @Column(name = "date_became_customer")
    private Date dateBecame;

    @Column(name = "payment_detail")
    private String paymentDetail;

    @Column(name = "other_customer_detail")
    private String otherCustomerDetail;

    @Column(name = "ref_payment_id")
    private Long refPaymentId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ref_payment_id", insertable = false, updatable = false)
    private RefPaymentEntity refPayment;
}
