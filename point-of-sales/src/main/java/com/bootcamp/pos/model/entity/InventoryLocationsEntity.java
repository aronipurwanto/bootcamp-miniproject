package com.bootcamp.pos.model.entity;

import com.bootcamp.pos.model.request.InventoryLocationRequest;
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
@Table(name = "tbl_inventory_locations")
public class InventoryLocationsEntity {
    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "product_id", length = 36)
    private String productId;

    @Column(name = "address_id", length = 36)
    private String addressId;

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

    public InventoryLocationsEntity(InventoryLocationRequest request, AddressEntity address) {
        BeanUtils.copyProperties(request, this);
        this.id = UUID.randomUUID().toString();
        this.address = address;
    }
}
