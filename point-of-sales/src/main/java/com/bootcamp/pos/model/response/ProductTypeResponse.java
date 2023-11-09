package com.bootcamp.pos.model.response;

import com.bootcamp.pos.model.entity.ProductTypeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductTypeResponse {
    private String id;
    private String productTypeCode;
    private String description;

    public ProductTypeResponse(ProductTypeEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
