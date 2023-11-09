package com.bootcamp.pos.model.request;

import com.bootcamp.pos.model.entity.PaymentMethodsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMethodsModel {
    private String id;
    private String paymentCode;
    private String creditCardName;
    private String paymentDesc;

    public PaymentMethodsModel(PaymentMethodsEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}