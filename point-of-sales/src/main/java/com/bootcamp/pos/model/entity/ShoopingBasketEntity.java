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
@Table(name ="tbl_shopping_basket")
public class ShoopingBasketEntity {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "basket_date")
    private LocalDateTime dateTime;

    @Column(name ="total_cost")
    private Integer totalCost;

    @Column(name = "other_basket_details")
    private String details;
}
