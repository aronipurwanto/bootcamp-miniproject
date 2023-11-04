package com.bootcamp.pos.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingBasketResponse {
    private Long id;
    private LocalDateTime basketDatetime;
    private Integer totalCost;
    private String basketDetail;
    private Long customerId;
}
