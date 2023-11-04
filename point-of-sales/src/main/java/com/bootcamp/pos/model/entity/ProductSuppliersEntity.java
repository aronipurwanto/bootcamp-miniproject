package com.bootcamp.pos.model.entity;

import com.bootcamp.pos.model.request.ProductSuppliersModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_product_suppliers")
public class ProductSuppliersEntity {
    @Id
    @Column(name = "product_supplier_id")
    private String id;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "supplier_id")
    private String supplierId;

    @Column(name = "supplied_to_date")
    private LocalDate suppliedToDate;

    @Column(name = "total_qty_supplied_to_date")
    private String totalQtySupToDate;

    @Column(name = "first_item_supplied_date")
    private String firstItemSupDate;

    @Column(name = "last_item_supplied_date")
    private String lastItemSupDate;

    @Column(name = "delivery_lead_time")
    private String deliveryLeadTime;

    @Column(name = "standard_price")
    private String standardPrice;

    @Column(name = "percent_discount")
    private String percentDiscount;

    @Column(name = "min_order_qty")
    private Integer minOrderQty;

    @Column(name = "max_order_qty")
    private Integer maxOrderQty;

    @Column(name = "item_suppliers_details")
    private String itemSuppliersDetails;

    public ProductSuppliersEntity(ProductSuppliersModel model) {
        BeanUtils.copyProperties(model, this);
        this.id = UUID.randomUUID().toString();
    }
}
