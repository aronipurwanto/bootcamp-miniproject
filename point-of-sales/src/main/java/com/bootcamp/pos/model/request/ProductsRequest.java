package com.bootcamp.pos.model.request;

import com.bootcamp.pos.model.entity.ProductsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsRequest {

    private String id;
    private String productTypeCode;
    private String productDetails;
    private String productName;
    private Double productPrice;
    private String description;

    public ProductsRequest(ProductsEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }

}
