package com.bootcamp.pos.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryLocationsResponse {

    private String id;
    private String productId;
    private String locationAddressId;
    private Double quantityStock;
    private Double orderLevel;
    private Double orderQuantity;
    private String averageMonth;
    private String inventoryDetails;

}
