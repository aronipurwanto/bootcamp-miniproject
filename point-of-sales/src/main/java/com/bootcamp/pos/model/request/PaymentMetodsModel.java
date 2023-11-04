package com.bootcamp.pos.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMetodsModel {
    private Long id;
    private String paymentCode;
    private String paymentDesc;
    private String creditCardName;
}