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
