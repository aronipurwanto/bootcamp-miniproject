package com.bootcamp.pos.model.response;

import com.bootcamp.pos.model.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

    private String id;

    private String details;

    private String name;

    private String price;

    private String description;

    public ProductResponse(ProductEntity entity) {
        BeanUtils.copyProperties(entity,this);

    }
}
