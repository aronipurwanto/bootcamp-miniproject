package com.bootcamp.pos.model.response;

import com.bootcamp.pos.model.entity.ProductEntity;
import com.bootcamp.pos.model.entity.RefProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefProductResponse {
    private String id;
    private String code;
    private String desc;
    private List<ProductEntity> product = new ArrayList<>();

    public RefProductResponse(RefProductEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
