package com.bootcamp.pos.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_basket_items")

public class BasketItemsEntity {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "cost")
    private Integer cost;
}
