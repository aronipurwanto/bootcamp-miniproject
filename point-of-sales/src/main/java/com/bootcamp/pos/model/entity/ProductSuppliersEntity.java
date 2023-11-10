package com.bootcamp.pos.model.entity;

import com.bootcamp.pos.model.response.ProductSuppliersResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_product_supplier")
public class ProductSuppliersEntity {

    @Id
    @Column(name = "id")
    private String id;
    //---------------Relasi ke product------------//
    @Column(name = "product_name")
    private String productttId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="product_name", insertable = false, updatable = false)
    private ProductEntity product;
    //---------------------------//

    //---------------Relasi ke product------------//
    @Column(name = "supplier_code")
    private String supId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supplier_code", insertable = false, updatable = false)
    private SuppliersEntity suppliers;
    //---------------------------//
    @Column(name = "value_supplied")
    private String valueSupplierToDate;

    @Column(name = "quantity_supplied")
    private String totalQtySupplier;

    @Column(name = "first_supplied")
    private String fitsItemSupDate;

    @Column(name = "last_supplied")
    private String lastItemSupDate;

    @Column(name = "delivery")
    private String deliveryLeadTime;

    @Column(name = "standart_price")
    private String standartPrice;

    @Column(name = "discount")
    private String percentDiscount;

    @Column(name = "min_order")
    private String maxOrderQty;

    @Column(name = "max_order")
    private String minOrderQty;

    @Column(name = "other_details")
    private String itemSupDetails;

    public ProductSuppliersEntity(ProductSuppliersResponse response) {
        BeanUtils.copyProperties(response, this);
        this.id = UUID.randomUUID().toString();
    }
}
