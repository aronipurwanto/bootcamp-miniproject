package com.bootcamp.pos.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryLocationsRequest {

    private String id;
    private String productId;
    private String locationAddressId;
    private Double quantityStock;
    private Double orderLevel;
    private Double orderQuantity;
    private String averageMonth;
    private String inventoryDetails;

}
