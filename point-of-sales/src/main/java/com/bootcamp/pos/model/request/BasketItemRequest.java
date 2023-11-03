package com.bootcamp.pos.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasketItemRequest {

    private String id;
    private String  productId;
    private LocalDate basketDateTime;
    private Double quantity;
    private Double cost;
}
