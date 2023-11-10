package com.bootcamp.pos.model.entity;

import com.bootcamp.pos.model.response.InventoryLocationResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="tbl_inventory_locations")
public class InventoryLocationEntity {
    @Id
    @Column(name = "inventory_location_id")
    private String locationId;


    //---------------Relasi ke Product------------//
    @Column(name = "product_id")
    private String productId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private ProductEntity product;
    //---------------------------//


    //---------------Relasi ke Address------------//
    @Column(name = "loc_address_id")
    private String locaddresId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "loc_address_id",insertable = false,updatable = false)
    private AddressesEntity addresses;
    //---------------------------//

    @Column(name = "quantity_in_stock")
    private String quantity;

    @Column(name = "reorder_level")
    private String reorderLevel;

    @Column(name = "reorder_quantity")
    private String reorderQuantity;

    @Column(name = "total_average_monthly_usage)")
    private String totalAverage;

    @Column(name = "other_inventory_details")
    private String inventoryDetails;

    public InventoryLocationEntity(InventoryLocationResponse response) {
        BeanUtils.copyProperties(response, this);
        this.locationId= UUID.randomUUID().toString();
    }
}
