package com.bootcamp.pos.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingBasketResponse {
    private String id;
    private String customerId;
    private LocalDate basketDateTime;
    private Double totalCost;
    private String otherDetails;
}
