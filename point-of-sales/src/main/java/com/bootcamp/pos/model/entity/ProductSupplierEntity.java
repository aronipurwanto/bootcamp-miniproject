package com.bootcamp.pos.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_product_supplier")
public class ProductSupplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "value_supplied")
    private Date valueSupplied;

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

    @Column(name = "product_id")
    private Long productId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private ProductEntity product;

    @Column(name = "supplier_id")
    private Long supplierId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supplier_id", insertable = false, updatable = false)
    private SupplierEntity supplier;



}
