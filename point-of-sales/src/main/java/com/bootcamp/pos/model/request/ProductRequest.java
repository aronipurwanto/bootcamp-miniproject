package com.bootcamp.pos.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private String productId;
    private String productTypeCode;
    private String productDetails;
    private String productName;
    private String productPrice;
    private String productDescription;
}
