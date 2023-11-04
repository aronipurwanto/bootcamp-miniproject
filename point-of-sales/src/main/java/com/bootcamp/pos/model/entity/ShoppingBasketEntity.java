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
@Table(name = "tbl_shopping_basket")
public class ShoppingBasketEntity {
    @Id
    @Column(name = "shopping_basket_id")
    private Long id;

    @Column(name = "basket_datetime")
    private LocalDateTime basketDatetime;

    @Column(name = "total_cost")
    private Integer totalCost;

    @Column(name = "bsaket_detail")
    private String basketDetail;

    @Column(name = "customer_id")
    private Long customerId;
}
