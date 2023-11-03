package com.bootcamp.pos.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_inventory_locations")
public class InventoryLocationsEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "productId")
    private Long productId;

    @Column(name = "location_address_id")
    private Long locationAddressId;

    @Column(name = "quantity_stock")
    private Double quantityStock;

    @Column(name = "order_level")
    private Double orderLevel;

    @Column(name = "order_quantity")
    private Double orderQuantity;

    @Column(name = "average_month")
    private String averageMonth;

    @Column(name = "inventory_details")
    private String inventoryDetails;
}
