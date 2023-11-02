package com.bootcamp.pos.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_inventory_locations")
public class InventoryLocations {

    @Id
    @TableGenerator(name = "tbl_inventory_locations_seq",
            table = "tbl_sequence",
            pkColumnName = "sequence_id",
            valueColumnName="sequence_value",
            pkColumnValue = "inventory_locations_id",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_inventory_locations_seq")
    @Column(name = "id")
    private Long id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private ProductsEntity productId;

    @Column(name = "location_address_id", nullable = false)
    private String locationAddressId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", insertable = false, updatable = false)
    private AddressEntity address;

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
