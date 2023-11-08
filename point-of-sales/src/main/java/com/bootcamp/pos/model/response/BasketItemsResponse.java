package com.bootcamp.pos.model.response;

import com.bootcamp.pos.model.entity.BasketItemsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class BasketItemsResponse {

    private String id;

    private String quantity;

    private String cost;

    public BasketItemsResponse(BasketItemsEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
