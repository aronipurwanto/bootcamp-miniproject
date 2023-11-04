package com.bootcamp.pos.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductsModel {
    private Long id;
    private Long productCodeId;
    private String prodctDetails;
    private String productName;
    private Integer productPrice;
    private String productDescription;
}
