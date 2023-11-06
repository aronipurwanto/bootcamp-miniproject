package com.bootcamp.pos.model.response;

import com.bootcamp.pos.model.entity.ProductEntity;
import com.bootcamp.pos.model.request.ProductSupplierRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private String id;
    private String details;
    private String name;
    private Double price;
    private String desc;
    private List<ProductSupplierRequest> productSupplier = new ArrayList<>();

    public ProductResponse(ProductEntity entity){
        BeanUtils.copyProperties(entity, this);
    }
}
