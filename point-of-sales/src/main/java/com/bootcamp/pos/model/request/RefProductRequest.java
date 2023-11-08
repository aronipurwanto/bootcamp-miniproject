package com.bootcamp.pos.model.request;

import com.bootcamp.pos.model.entity.ProductEntity;
import com.bootcamp.pos.model.entity.RefAddressEntity;
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
public class RefProductRequest {
    private String id;
    private String code;
    private String desc;
    private List<ProductEntity> product = new ArrayList<>();

    public RefProductRequest(RefProductEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
