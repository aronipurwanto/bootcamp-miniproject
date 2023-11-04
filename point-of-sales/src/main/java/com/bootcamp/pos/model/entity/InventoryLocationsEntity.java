package com.bootcamp.pos.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_inventory_location")
public class InventoryLocationsEntity {
    @Id
    @Column(name = "inventory_location_id")
    private Long invLocId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "location_address_id")
    private Long locAddressId;

    @Column(name = "quantity_in_stock")
    private Integer qtyInStock;

    @Column(name = "reorder_level")
    private Integer reorderLevel;

    @Column(name = "reorder_qty")
    private Integer reorderQty;

    @Column(name = "total_avg_month-usage")
    private String totalAvgMonthUsg;

    @Column(name = "inventory_details")
    private String inventoryDetails;
}
