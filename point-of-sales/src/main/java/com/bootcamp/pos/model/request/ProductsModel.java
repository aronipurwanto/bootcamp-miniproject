package com.bootcamp.pos.model.request;

import com.bootcamp.pos.model.entity.ProductsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductsModel {
    private String id;

    private String productTypeId;
    private ProductTypeModel productType;

    private String productDetails;
    private String productName;
    private Integer productPrice;
    private String productDescription;

    public ProductsModel(ProductsEntity entity) {
        BeanUtils.copyProperties(entity, this);

        if (entity.getProductType() != null){
            this.productTypeId = entity.getProductType().getId();
            this.productType = new ProductTypeModel(entity.getProductType());
        }
    }
}
