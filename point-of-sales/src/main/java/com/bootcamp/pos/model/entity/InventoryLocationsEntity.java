package com.bootcamp.pos.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
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
    @TableGenerator(name = "tbl_inventory_location_seq",
            table = "tbl_sequence",
            pkColumnName = "sequence_id",
            valueColumnName = "sequence_value",
            pkColumnValue = "inventory_location_id",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_inventory_location_seq")
    @Column(name = "inventory_location_id")
    private Long invLocId;

    @Column(name = "product_id")
    private Long productId;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private ProductsEntity productsEntity;

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
