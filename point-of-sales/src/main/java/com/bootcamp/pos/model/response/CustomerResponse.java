package com.bootcamp.pos.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {
    private String customerId;
    private String paymentMethodCode;
    private String customerName;
    private String customerPhone;
    private String customerEmail;
    private String dateBecameCustomer;
    private String paymentDetails;
}
