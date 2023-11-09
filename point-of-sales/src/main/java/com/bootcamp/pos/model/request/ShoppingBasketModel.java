package com.bootcamp.pos.model.request;

import com.bootcamp.pos.model.entity.ShoppingBasketEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingBasketModel {
    private String id;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDateTime basketDatetime;
    private Integer totalCost;
    private String basketDetail;

    private String customerId;
    private CustomerRequest customer;

    public ShoppingBasketModel(ShoppingBasketEntity entity) {
        BeanUtils.copyProperties(entity, this);

        if (entity.getCustomer() != null){
            this.customerId = entity.getCustomer().getId();
            this.customer = new CustomerRequest(entity.getCustomer());
        }
    }
}
