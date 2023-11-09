package com.bootcamp.pos.model.request;

import com.bootcamp.pos.model.entity.BasketItemEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasketItemModel {
    private String id;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDateTime basketDatetime;
    private Integer quantity;
    private String cost;

    private String customerId;
    private CustomerRequest customer;

    private String productId;
    private ProductsModel products;

    public BasketItemModel(BasketItemEntity entity) {
        BeanUtils.copyProperties(entity, this);

        if (entity.getCustomer() != null){
            this.customerId = entity.getCustomer().getId();
            this.customer = new CustomerRequest(entity.getCustomer());
        }
        if (entity.getProducts() != null){
            this.productId = entity.getProducts().getId();
            this.products = new ProductsModel(entity.getProducts());
        }
    }
}
