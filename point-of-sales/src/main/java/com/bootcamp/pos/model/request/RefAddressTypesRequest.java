package com.bootcamp.pos.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefAddressTypesRequest {
    private String addressTypeCode;
    private String addressTypeDescription;
    private String egBillingDeliveryResidential;
}
