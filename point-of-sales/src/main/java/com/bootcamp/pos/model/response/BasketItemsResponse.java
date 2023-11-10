package com.bootcamp.pos.model.response;

import com.bootcamp.pos.model.entity.BasketItemsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class BasketItemsResponse {

    private String id;
    //---------------Relasi ke Customer------------//
    private String customerId;
    private String name;
    //---------------------------//

    //---------------Relasi ke Shopping Basket------------//
    private String basketDtmId;

    private LocalDate dateTime;
    //---------------------------//

    //---------------Relasi ke Product------------//
    private String producttId;

    private String productName;
    //---------------------------//
    private String quantity;

    private String cost;

    public BasketItemsResponse(BasketItemsEntity entity) {
        BeanUtils.copyProperties(entity, this);
        if(entity.getCustomer() != null){
            customerId = entity.getCustomerId();
            name = entity.getCustomer().getName();
        }
        if(entity.getShoopingBasket() != null) {
            basketDtmId = entity.getBasketDtmId();
            dateTime = entity.getShoopingBasket().getDateTime().toLocalDate();
        }
        if(entity.getProduct() != null){
            producttId = entity.getProducttId();
            productName = entity.getProduct().getName();
        }
    }
}
