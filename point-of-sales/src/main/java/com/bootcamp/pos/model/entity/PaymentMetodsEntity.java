package com.bootcamp.pos.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_payment")
public class PaymentMetodsEntity {
    @Id
    @Column(name = "payment_id")
    private Long id;

    @Column(name = "payment_code")
    private String paymentCode;

    @Column(name = "payment_description")
    private String paymentDesc;

    @Column(name = "credit_card_name")
    private String creditCardName;
}