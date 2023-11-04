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
@Table(name = "tbl_product_supplier")
public class ProductSuppliersEntity {

    @Id
    @Column(name = "id")
    private Long id;


    //--------Relasi ke Product--------//
    @Column(name = "product_id")
    private Long productId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private ProductEntity product;
    //----------------//


    //--------Relasi ke Suppliers--------//
    @Column(name = "supplier_code")
    private String supplierCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supplier_code")
    private SuppliersEntity suppliers;
    //----------------//

    @Column(name = "value_supplied_to_date")
    private Date valueSupplierToDate;

    @Column(name = "total_quantity_supplied_to_date")
    private String totalQtySupplier;

    @Column(name = "first_item_supplied_date")
    private String fitsItemSupDate;

    @Column(name = "last_item_supplied_date")
    private String lastItemSupDate;

    @Column(name = "delivery_lead_time")
    private String deliveryLeadTime;

    @Column(name = "standart_price")
    private Integer standartPrice;

    @Column(name = "percentage_discount")
    private String percentDiscount;

    @Column(name = "min_order_quantity")
    private Integer maxOrderQty;

    @Column(name = "max_order_quantity")
    private Integer minOrderQty;

    @Column(name = "other_ite,_suppliers_details")
    private String itemSupDetails;
}
