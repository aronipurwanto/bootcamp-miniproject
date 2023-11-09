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
@Table(name = "product_suppliers")
public class ProductSuppliers {
    @Id
    @Column(name = "product_id")
    private String productId;

    @Column(name = "supplier_code")
    private String supplierCode;

    @Column(name = "value_supplied_to_date")
    private String valueSuppliedToDate;

    @Column(name = "total_quantity_supplied_date")
    private String totalQuantitySuppliedDate;

    @Column(name = "first_item_supplied_date")
    private String firstItemSuppliedDate;

    @Column(name = "last_item_supplied_date")
    private String lastItemSuppliedDate;

    @Column(name = "delivery_lead_time")
    private String deliveryLeadTime;

    @Column(name = "standard_price")
    private String standardPrice;

    @Column(name = "percentage_discount")
    private String percentageDiscount;

    @Column(name = "minimum_order_quantity")
    private String minimumOrderQuantity;

    @Column(name = "maximum_order_quantity")
    private String maximumOrderQuantity;

    @Column(name = "other_item_suppliers_details")
    private String otherItemSuppliersDetails;
}
