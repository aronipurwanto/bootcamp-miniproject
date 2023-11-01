package com.bootcamp.pos.model.entity;

import jakarta.persistence.*;
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
    @TableGenerator(name = "tbl_payment_seq",
            table = "tbl_sequence",
            pkColumnName = "sequence_id",
            valueColumnName = "sequence_value",
            pkColumnValue = "payment_id",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_payment_seq")
    @Column(name = "payment_id")
    private Long id;

    @Column(name = "payment_code")
    private String paymentCode;

    @Column(name = "payment_description")
    private String paymentDesc;

    @Column(name = "credit_card_name")
    private String creditCardName;
}