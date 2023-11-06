package com.bootcamp.pos.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class BasketItemsRequest {

    private String id;

    private LocalDateTime dateTime;

    private Integer quantity;

    private Integer cost;
}
