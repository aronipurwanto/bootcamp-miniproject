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
public class ShoppingBasketRequest {
    private String id;
    private String customerId;
    private CustomerRequest customer;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDateTime basketDateTime;
    private Double totalCost;
    private String otherBasketDetail;

    public ShoppingBasketRequest(ShoppingBasketEntity entity) {
        BeanUtils.copyProperties(entity, this);

        if (entity.getCustomer() != null){
            this.customerId = entity.getCustomerId();
            this.customer = new CustomerRequest(entity.getCustomer());
        }
    }
}
