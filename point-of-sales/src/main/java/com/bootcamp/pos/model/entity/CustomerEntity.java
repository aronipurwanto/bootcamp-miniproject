package com.bootcamp.pos.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    //--------Relasi ke Ref Payment Methods--------//
    @Column(name = "payment_method_code")
    private String paymentCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "payment_method_code", insertable = false, updatable = false)
    private RefPaymentEntity refPayment;
    //-----------------------------------------------//

    @Column(name = "customer_name")
    private String name;

    @Column(name = "customer_phone")
    private Integer phone;

    @Column(name = "customer_email")
    private String email;

    @Column(name = "date_became_customer")
    private Date date;

    @Column(name = "payment_details")
    private String paymentDetails;

    @Column(name = "other_customer_details")
    private String customerDetails;
}
