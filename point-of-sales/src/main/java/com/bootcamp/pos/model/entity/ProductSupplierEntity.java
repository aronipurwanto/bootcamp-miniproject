package com.bootcamp.pos.model.entity;

import com.bootcamp.pos.model.request.ProductSupplierRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.sql.Time;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_product_supplier")
public class ProductSupplierEntity {
    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "code")
    private String code;

    @Column(name = "value_supplied")
    private String valueSupplied;

    @Column(name = "total_quantity_supplied")
    private String totalQuantitySupplied;

    @Column(name = "first_item_supplied")
    private String firstItemSupplied;

    @Column(name = "last_item_supplied")
    private String lastItemSupplied;

    @Column(name = "delivery_lead")
    private String deliveryLead;

    @Column(name = "standard_price")
    private Double standardPrice;

    @Column(name = "percentage_discount")
    private String percentageDiscount;

    @Column(name = "minimum_order_quantity")
    private Double minimumOrderQuantity;

    @Column(name = "maximum_order_quantity")
    private Double maximumOrderQuantity;

    @Column(name = "other_item_supplier_detail")
    private String otherItemSupplierDetail;

    @Column(name = "product_id", length = 36)
    private String productId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private ProductEntity product;

    @Column(name = "supplier_id", length = 36)
    private String supplierId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supplier_id", insertable = false, updatable = false)
    private SupplierEntity supplier;

    public ProductSupplierEntity(ProductSupplierRequest request, ProductEntity product) {
        BeanUtils.copyProperties(request, this);
        this.id = UUID.randomUUID().toString();
        this.product = product;
    }

}
