package com.bootcamp.pos.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_basket_items")
public class BasketItemsEntity {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "basket_date", length = 100)
    private LocalDate basketDatetime;

    @Column(name = "quantity", length = 60)
    private Double quantity;

    @Column(name = "cost")
    private Double cost;
}
