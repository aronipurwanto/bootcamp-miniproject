package com.bootcamp.pos.model.response;

import com.bootcamp.pos.model.entity.ShoopingBasketEntity;
import com.fasterxml.jackson.databind.util.BeanUtil;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ShopBasketResponse {
    private String id;

    private String customerId;

    private String name;


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dateTime;

    private String totalCost;

    private String details;

    public ShopBasketResponse(ShoopingBasketEntity entity) {
        BeanUtils.copyProperties(entity, this);
        if(entity.getCustomer() != null){
            customerId = entity.getCustomerId();
            name = entity.getCustomer().getName();
        }
    }
}
