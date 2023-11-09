package com.bootcamp.pos.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingBasketRequest {
    private String customerId;
    private String basketDateTime;
    private String totalCost;
    private  String otherBasketDetails;
}
