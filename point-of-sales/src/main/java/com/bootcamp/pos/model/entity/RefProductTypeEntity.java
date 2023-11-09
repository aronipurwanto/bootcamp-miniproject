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
@Table(name = "tbl_ref_product_type")
public class RefProductTypeEntity {
    @Id
    @Column(name = "product_type_code")
    private String productTypeCode;

    @Column(name = "product_type_description")
    private String productTypeDescription;

    @Column(name = "egFruit_Toy")
    private String egFruitToy;
}
