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
@Table(name = "tbl_basket_item")
public class BasketItemsEntity {
    @Id
    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "basket_datetime")
    private String basketDateTime;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "cost")
    private String cost;
}
