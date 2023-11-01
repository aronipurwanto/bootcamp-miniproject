package com.bootcamp.pos.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_product_suppliers")
public class ProductSuppliersEntity {
    @Id
    @TableGenerator(name = "tbl_products_supplier_seq",
            table = "tbl_sequence",
            pkColumnName = "sequence_id",
            valueColumnName = "sequence_value",
            pkColumnValue = "products_supplier_id",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_products_supplier_seq")
    @Column(name = "product_supplier_id")
    private Long productSupplierId;

    @Column(name = "product_id")
    private Long productId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private ProductsEntity productsEntity;

    @Column(name = "supplier_code")
    private String supplierCode;

    @Column(name = "supplied_to_date")
    private Date suppliedToDate;

    @Column(name = "total_qty_sup_to_date")
    private String totalQtySupToDate;

    @Column(name = "first_item_sup_date")
    private String firstItemSupDate;

    @Column(name = "last_item_sup_date")
    private String lastItemSupDate;

    @Column(name = "delivery_lead_time")
    private String deliveryLeadTime;

    @Column(name = "standard_price")
    private Integer standardPrice;

    @Column(name = "percent_discount")
    private String percentDiscount;

    @Column(name = "min_order_qty")
    private Integer minOrderQty;

    @Column(name = "max_order_qty")
    private Integer maxOrderQty;

    @Column(name = "item_suppliers_details")
    private String itemSuppliersDetails;
}
