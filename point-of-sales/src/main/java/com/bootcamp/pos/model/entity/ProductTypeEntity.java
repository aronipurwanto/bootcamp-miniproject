package com.bootcamp.pos.model.entity;

import com.bootcamp.pos.model.request.ProductTypeModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_product_type")
public class ProductTypeEntity {
    @Id
    @Column(name = "product_type_id")
    private String id;

    @Column(name = "product_type_code")
    private String productTypeCode;

    @Column(name = "description")
    private String description;

    public ProductTypeEntity(ProductTypeModel model) {
        BeanUtils.copyProperties(model, this);
        this.id = UUID.randomUUID().toString();
    }
}
