package com.bootcamp.pos.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_product_suppliers")
public class ProductSuppliersEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "supplier_code")
    private Long supplierCode;

    @Column(name = "value_supplied")
    private String valueSupplied;

    @Column(name = "total_supplied")
    private String totalSupplied;

    @Column(name = "first_supplied")
    private String firstSupplied;

    @Column(name = "last_supplied")
    private String lastSupplied;

    @Column(name = "delivery")
    private String delivery;

    @Column(name = "standart_price")
    private Double standardPrice;

    @Column(name = "discount")
    private String discount;

    @Column(name = "min_order")
    private Double minOrder;

    @Column(name = "max_order")
    private Double maxOrder;

    @Column(name = "item_supplier_details")
    private String itemSupplierDetails;

}
