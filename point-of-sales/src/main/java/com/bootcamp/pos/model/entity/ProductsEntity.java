package com.bootcamp.pos.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_products")
public class ProductsEntity {
    @Id
    @TableGenerator(name = "tbl_products_seq",
            table = "tbl_sequence",
            pkColumnName = "sequence_id",
            valueColumnName = "sequence_value",
            pkColumnValue = "products_id",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_products_seq")
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_code_id")
    private Long productCodeId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_code_id", insertable = false, updatable = false)
    private ProductTypeEntity productTypeEntity;

    @Column(name = "product_details")
    private String prodctDetails;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private Integer productPrice;

    @Column(name = "product_description")
    private String productDescription;
}
