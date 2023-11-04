package com.bootcamp.pos.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductsResponse {
    private Long id;
    private Long productCodeId;
    private String prodctDetails;
    private String productName;
    private Integer productPrice;
    private String productDescription;
}
