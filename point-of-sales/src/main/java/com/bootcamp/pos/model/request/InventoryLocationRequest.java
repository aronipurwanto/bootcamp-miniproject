package com.bootcamp.pos.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryLocationRequest {

    private String locationId;

    private String quantity;

    private String reorderLevel;

    private String reorderQuantity;

    private String totalAverage;

    private String inventoryDetails;
}
