package com.bootcamp.pos.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="tbl_inventory_locations")
public class InventoryLocationEntity {
    @Id

    @Column(name = "inventory_location_id")
    private Long locationId;

    @Column(name = "quantity_in_stock")
    private Integer quantity;

    @Column(name = "reorder_level")
    private Integer reorderLevel;

    @Column(name = "reorder_quantity")
    private Integer reorderQuantity;

    @Column(name = "total_average_monthly_usage)")
    private Integer totalAverage;

    @Column(name = "other_inventory_details")
    private String inventoryDetails;
}
