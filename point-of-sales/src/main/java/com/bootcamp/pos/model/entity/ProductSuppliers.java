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
public class ProductSuppliers {

    @Id
    @TableGenerator(name = "tbl_product_suppliers_seq",
            table = "tbl_sequence",
            pkColumnName = "sequence_id",
            valueColumnName="sequence_value",
            pkColumnValue = "product_suppliers_id",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_product_suppliers_seq")
    @Column(name = "id")
    private Long id;

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

    @Column(name = "product_id")
    private String productId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "products_id", insertable = false, updatable = false)
    private ProductsEntity products;

    @Column(name = "supplier_code")
    private String supplierCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supplier_code", insertable = false, updatable = false)
    private SuppliersEntity suppliers;

}
