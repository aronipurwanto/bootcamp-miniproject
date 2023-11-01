package com.bootcamp.pos.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "product_details")
    private String details;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_price")
    private Double price;

    @Column(name = "product_description")
    private String desc;

    @Column(name = "ref_product_id")
    private Long refProductId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ref_product_id", insertable = false, updatable = false)
    private RefProductEntity refProduct;

}
