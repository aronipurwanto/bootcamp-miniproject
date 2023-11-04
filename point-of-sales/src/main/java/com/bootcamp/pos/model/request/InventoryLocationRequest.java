package com.bootcamp.pos.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryLocationRequest {

    private Long locationId;

    private Long productId;

    private ProductRequest product;

    private Long addressId;

    private Integer quantity;

    private Integer reorderLevel;

    private Integer reorderQuantity;

    private Integer totalAverage;

    private String inventoryDetails;
}
