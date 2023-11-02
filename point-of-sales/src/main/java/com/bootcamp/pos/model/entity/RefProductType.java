package com.bootcamp.pos.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_refproduct_type")
public class RefProductType {

    @Id
    @TableGenerator(name = "tbl_basket_items_seq",
            table = "tbl_sequence",
            pkColumnName = "sequence_id",
            valueColumnName="sequence_value",
            pkColumnValue = "basket_items_id",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_basket_items_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "product_type_desc")
    private String productTypeDesc;
}
