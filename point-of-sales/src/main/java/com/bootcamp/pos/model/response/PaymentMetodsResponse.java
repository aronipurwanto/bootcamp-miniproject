package com.bootcamp.pos.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMetodsResponse {
    private Long id;
    private String paymentCode;
    private String paymentDesc;
    private String creditCardName;
}