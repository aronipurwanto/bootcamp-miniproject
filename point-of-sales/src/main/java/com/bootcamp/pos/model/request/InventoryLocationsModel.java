package com.bootcamp.pos.model.request;

import com.bootcamp.pos.model.entity.InventoryLocationsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryLocationsModel {
    private String id;

    private String productId;
    private ProductsModel products;

    private String addressId;
    private AddressModel address;

    private Integer qtyInStock;
    private String reorderLevel;
    private Integer reorderQty;
    private String totalAvgMonthUsg;
    private String inventoryDetails;

    public InventoryLocationsModel(InventoryLocationsEntity entity) {
        BeanUtils.copyProperties(entity, this);

        if (entity.getProducts() != null){
            this.productId = entity.getProducts().getId();
            this.products = new ProductsModel(entity.getProducts());
        }
        if (entity.getAddress() != null){
            this.addressId = entity.getAddress().getId();
            this.address = new AddressModel(entity.getAddress());
        }
    }
}
