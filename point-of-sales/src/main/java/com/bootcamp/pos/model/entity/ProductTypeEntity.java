package com.bootcamp.pos.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_product_type")
public class ProductTypeEntity {
    @Id
    @TableGenerator(name = "tbl_products_type_seq",
            table = "tbl_sequence",
            pkColumnName = "sequence_id",
            valueColumnName = "sequence_value",
            pkColumnValue = "products_type_id",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_products_type_seq")
    @Column(name = "product_type_id")
    private Long id;

    @Column(name = "product_type_code")
    private String productTypeCode;

    @Column(name = "description")
    private String description;
}
