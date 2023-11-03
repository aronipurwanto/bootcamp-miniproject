package com.bootcamp.pos.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefPaymentMethodRequest {

    private String id;
    private String paymentCode;
    private String paymentDesc;
}
