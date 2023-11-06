package com.bootcamp.pos.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryLocationRequest {

    private String locationId;

    private ProductRequest product;

    private Integer quantity;

    private Integer reorderLevel;

    private Integer reorderQuantity;

    private Integer totalAverage;

    private String inventoryDetails;
}
