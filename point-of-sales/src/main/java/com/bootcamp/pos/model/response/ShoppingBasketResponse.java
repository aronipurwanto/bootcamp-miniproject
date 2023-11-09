package com.bootcamp.pos.model.response;

import com.bootcamp.pos.model.entity.ShoppingBasketEntity;
import com.bootcamp.pos.model.request.CustomerRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingBasketResponse {
    private String id;
    private String customerId;
    private CustomerRequest customer;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalDateTime basketDateTime;
    private Double totalCost;
    private String otherBasketDetail;

    public ShoppingBasketResponse(ShoppingBasketEntity entity) {
        BeanUtils.copyProperties(entity, this);

        if (entity.getCustomer() != null){
            this.customerId = entity.getCustomerId();
            this.customer = new CustomerRequest(entity.getCustomer());
        }
    }
}
