package com.bootcamp.pos.model.request;

import com.bootcamp.pos.model.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private String id;
    private String details;
    private String name;
    private String price;
    private String desc;
    private List<ProductSupplierRequest> productSupplier = new ArrayList<>();

    public ProductRequest(ProductEntity entity){
        BeanUtils.copyProperties(entity, this);
    }
}
