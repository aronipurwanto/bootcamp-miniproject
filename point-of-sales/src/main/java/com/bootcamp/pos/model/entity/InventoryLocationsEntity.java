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
@Table(name = "tbl_inventory_locations")
public class InventoryLocationsEntity {
    @Id
    @Column(name = "inventory_location_id")
    private String inventoryLocationsId;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "location_address_id")
    private String locationsAddressId;

    @Column(name = "quantity_in_stock")
    private String quantityInStock;

    @Column(name = "reorder_level")
    private String reorderLevel;

    @Column(name = "reorder_quantity")
    private String reorderQuantity;

    @Column(name = "total_average_monthly_usage")
    private String totalAverageMonthlyUsage;

    @Column(name = "other_inventory_details")
    private String otherInventoryDetails;
}
