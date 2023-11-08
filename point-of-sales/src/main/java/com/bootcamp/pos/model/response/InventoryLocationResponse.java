package com.bootcamp.pos.model.response;

import com.bootcamp.pos.model.entity.InventoryLocationsEntity;
import com.bootcamp.pos.model.request.AddressRequest;
import com.bootcamp.pos.model.request.ProductRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryLocationResponse {
    private String id;
    private String productId;
    private String addressId;
    private ProductRequest product;
    private AddressRequest address;
    private Double quantityInStock;
    private Double reorderLevel;
    private Double reorderQuantity;
    private String totalAverageMonthlyUsage;
    private String otherInventoryDetail;

    public InventoryLocationResponse(InventoryLocationsEntity inventoryLocations) {
        BeanUtils.copyProperties(inventoryLocations, this);

        if (inventoryLocations.getProduct() != null){
            this.productId = inventoryLocations.getProductId();
            this.product = new ProductRequest(inventoryLocations.getProduct());
        }

        if (inventoryLocations.getAddress() != null){
            this.addressId = inventoryLocations.getAddressId();
            this.address = new AddressRequest(inventoryLocations.getAddress());
        }
    }
}
