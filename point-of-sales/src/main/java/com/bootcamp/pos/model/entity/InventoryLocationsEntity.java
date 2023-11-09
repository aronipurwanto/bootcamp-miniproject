package com.bootcamp.pos.model.entity;

import com.bootcamp.pos.model.request.InventoryLocationsModel;
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
@Table(name = "tbl_inventory_location")
public class InventoryLocationsEntity {
    @Id
    @Column(name = "inventory_location_id")
    private String id;

    @Column(name = "product_id")
    private String productId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private ProductsEntity products;

    @Column(name = "address_id")
    private String addressId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", insertable = false, updatable = false)
    private AddressEntity address;

    @Column(name = "quantity_in_stock")
    private Integer qtyInStock;

    @Column(name = "reorder_level")
    private String reorderLevel;

    @Column(name = "reorder_qty")
    private Integer reorderQty;

    @Column(name = "total_avg_month-usage")
    private String totalAvgMonthUsg;

    @Column(name = "inventory_details")
    private String inventoryDetails;

    public InventoryLocationsEntity(InventoryLocationsModel model) {
        BeanUtils.copyProperties(model, this);
        this.id = UUID.randomUUID().toString();
    }
}
