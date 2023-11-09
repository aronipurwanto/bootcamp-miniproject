package com.bootcamp.pos.model.request;

import com.bootcamp.pos.model.entity.BasketItemEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasketItemRequest {
    private String id;
    private LocalDateTime basketDateTime;
    private Double quantity;
    private Double cost;
    private String customerId;
    private CustomerRequest customer;
    private String productId;
    private ProductRequest product;

    public BasketItemRequest(BasketItemEntity entity) {
        BeanUtils.copyProperties(entity, this);

        if (entity.getCustomer() != null){
            this.customerId = entity.getCustomerId();
            this.customer = new CustomerRequest(entity.getCustomer());
        }

        if (entity.getProduct() != null){
            this.productId = entity.getProductId();
            this.product = new ProductRequest(entity.getProduct());
        }
    }
}
