package com.bootcamp.pos.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class BasketItemsRequest {

    private Long id;

    private Long customerId;

    private LocalDateTime dateTime;

    private Long productId;

    private Integer quantity;

    private Integer cost;
}
