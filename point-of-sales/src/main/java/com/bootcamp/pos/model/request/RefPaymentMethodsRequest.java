package com.bootcamp.pos.model.request;

import com.bootcamp.pos.model.entity.RefPaymentMethodsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefPaymentMethodsRequest {
    private String id;
    private String paymentMethodCode;
    private String paymentMethodDescription;

    public RefPaymentMethodsRequest(RefPaymentMethodsEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
