package com.bootcamp.pos.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefPaymentMethodResponse {

    private String id;
    private String paymentCode;
    private String paymentDesc;
}
