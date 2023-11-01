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
@Table(name ="tbl_ref_payment_methods")
public class RefPaymentEntity {
    @Id
    @Column(name ="payment_method_code")
    private String code;

    @Column(name = "payment_method_description")
    private String desc;
}
