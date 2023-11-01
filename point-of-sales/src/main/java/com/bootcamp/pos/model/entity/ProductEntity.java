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
public class ProductEntity {
    @Id
    @Column(name = "product_id")
    private Long id;

    //--------Relasi ke Ref Product Types--------//
    @Column(name = "product_type_code")
    private String code;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_type_code")
    private RefProductTypeEntity refProductType;
    //------------------------------//

    @Column(name = "product_details")
    private String details;

    @Column(name = "product_name")
    private String name;

    @Column(name ="product_price")
    private String price;

    @Column(name = "product_description")
    private String description;
}
