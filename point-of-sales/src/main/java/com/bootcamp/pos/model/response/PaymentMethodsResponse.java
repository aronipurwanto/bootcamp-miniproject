package com.bootcamp.pos.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMethodsResponse {
    private String id;
    private String paymentCode;
    private String creditCardName;
    private String paymentDesc;
}