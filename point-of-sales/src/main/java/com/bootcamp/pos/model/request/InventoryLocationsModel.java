package com.bootcamp.pos.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryLocationsModel {
    private Long invLocId;
    private Long productId;
    private Long locAddressId;
    private Integer qtyInStock;
    private Integer reorderLevel;
    private Integer reorderQty;
    private String totalAvgMonthUsg;
    private String inventoryDetails;
}
