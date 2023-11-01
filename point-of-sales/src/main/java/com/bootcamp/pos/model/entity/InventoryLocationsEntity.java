package com.bootcamp.pos.model.entity;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "address_id")
    private Long addressId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private ProductEntity product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", insertable = false, updatable = false)
    private AddressEntity address;

    @Column(name = "quantity_in_stock")
    private Double quantityInStock;

    @Column(name = "reorder_level")
    private Double reorderLevel;

    @Column(name = "reorder_quantity")
    private Double reorderQuantity;

    @Column(name = "total_average_monthly_usage")
    private String totalAverageMonthlyUsage;

    @Column(name = "other_Inventory_detail")
    private String otherInventoryDetail;




}
