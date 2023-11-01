package com.bootcamp.pos.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BasketItemsEntity {
    private Long customerId;
    private LocalDateTime dateTime;
    private Long productId;
    private Integer quantity;
    private Integer cost;
}
