package com.bootcamp.pos.model.entity;

import com.bootcamp.pos.model.response.ProductResponse;
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
public class ProductEntity {
    @Id
    @Column(name = "product_id")
    private String id;

    @Column(name = "product_details")
    private String details;

    @Column(name = "product_name")
    private String name;

    @Column(name ="product_price")
    private String price;

    @Column(name = "product_description")
    private String description;

    public ProductEntity(ProductResponse response) {
        BeanUtils.copyProperties(response, this);
        this.id = UUID.randomUUID().toString();
    }
}
