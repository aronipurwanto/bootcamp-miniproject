package com.bootcamp.pos.model.entity;

import com.bootcamp.pos.model.request.ProductsModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_products")
public class ProductsEntity {
    @Id
    @Column(name = "product_id")
    private String id;

    @Column(name = "product_type_id")
    private String productTypeId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_type_id", insertable = false, updatable = false)
    private ProductTypeEntity productType;

    @Column(name = "product_details")
    private String productDetails;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private Integer productPrice;

    @Column(name = "product_description")
    private String productDescription;

    public ProductsEntity(ProductsModel model) {
        BeanUtils.copyProperties(model, this);
        this.id = UUID.randomUUID().toString();
    }
}
