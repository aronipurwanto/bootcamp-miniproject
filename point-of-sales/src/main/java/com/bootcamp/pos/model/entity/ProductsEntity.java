package com.bootcamp.pos.model.entity;

import com.bootcamp.pos.model.request.ProductsRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_product")
public class ProductsEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "product_code")
    private String productTypeCode;

    @Column(name = "product_details")
    private String productDetails;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private Double productPrice;

    @Column(name = "description")
    private String description;

    public ProductsEntity(ProductsRequest request) {
        BeanUtils.copyProperties(request, this);
        this.id = UUID.randomUUID().toString();
    }
}
