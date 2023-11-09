package com.bootcamp.pos.model.response;

import com.bootcamp.pos.model.request.AddressModel;
import com.bootcamp.pos.model.request.ProductsModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryLocationsResponse {
    private String invLocId;

    private String productId;
    private ProductsModel products;

    private String locAddressId;
    private AddressModel locAddress;

    private Integer qtyInStock;
    private String reorderLevel;
    private Integer reorderQty;
    private String totalAvgMonthUsg;
    private String inventoryDetails;
}
