package com.bootcamp.pos.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasketItemModel {
    private Long basketId;
    private Long customerId;
    private LocalDateTime basketDatetime;
    private Long productId;
    private Integer quantity;
    private Double cost;
}
