package com.bootcamp.pos.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasketItemsRequest {
    private String customerId;
    private String basketDateTime;
    private String productId;
    private String quantity;
    private String cost;
}
