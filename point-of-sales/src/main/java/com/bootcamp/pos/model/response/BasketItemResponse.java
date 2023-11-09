package com.bootcamp.pos.model.response;

import com.bootcamp.pos.model.entity.BasketItemEntity;
import com.bootcamp.pos.model.request.CustomerRequest;
import com.bootcamp.pos.model.request.ProductRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasketItemResponse {
    private String id;
    private LocalDateTime basketDateTime;
    private Double quantity;
    private Double cost;
    private String customerId;
    private CustomerRequest customer;
    private String productId;
    private ProductRequest product;

    public BasketItemResponse(BasketItemEntity entity) {
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
