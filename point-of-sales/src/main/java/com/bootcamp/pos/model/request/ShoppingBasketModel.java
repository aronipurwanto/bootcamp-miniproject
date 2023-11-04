package com.bootcamp.pos.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingBasketModel {
    private Long id;
    private LocalDateTime basketDatetime;
    private Integer totalCost;
    private String basketDetail;
    private Long customerId;
}
