package com.bootcamp.pos.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_basket_item")
public class BasketItemEntity {
    @Id
    @Column(name = "basket_item_id")
    private Long basketId;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "basket_datetime")
    private LocalDateTime basketDatetime;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "basket_quantity")
    private Integer quantity;

    @Column(name = "cost")
    private Double cost;
}
