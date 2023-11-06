package com.bootcamp.pos.model.entity;

import com.bootcamp.pos.model.request.ProductRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_product")
public class ProductEntity {
    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "product_details")
    private String details;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_price")
    private String price;

    @Column(name = "product_description")
    private String desc;

    @Column(name = "ref_product_id", length = 36)
    private String refProductId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ref_product_id", insertable = false, updatable = false)
    private RefProductEntity refProduct;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductSupplierEntity> productSupplier = new ArrayList<>();

    public ProductEntity(ProductRequest request) {
        BeanUtils.copyProperties(request, this);
        this.id = UUID.randomUUID().toString();

    }
}
