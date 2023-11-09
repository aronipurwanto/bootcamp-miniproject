package com.bootcamp.pos.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryLocationsRequest {
    private String inventoryLocationsId;
    private String productId;
    private String locationsAddressId;
    private String quantityInStock;
    private String reorderLevel;
    private String reorderQuantity;
    private String totalAverageMonthlyUsage;
    private String otherInventoryDetails;
}
