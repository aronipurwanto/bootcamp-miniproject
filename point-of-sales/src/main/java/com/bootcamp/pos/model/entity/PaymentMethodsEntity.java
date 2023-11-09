package com.bootcamp.pos.model.entity;

import com.bootcamp.pos.model.request.PaymentMethodsModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_payment_methods")
public class PaymentMethodsEntity {
    @Id
    @Column(name = "payment_methods_id")
    private String id;

    @Column(name = "payment_code")
    private String paymentCode;

    @Column(name = "credit_card_name")
    private String creditCardName;

    @Column(name = "payment_description")
    private String paymentDesc;

    public PaymentMethodsEntity(PaymentMethodsModel model) {
        BeanUtils.copyProperties(model, this);
        this.id = UUID.randomUUID().toString();
    }
}