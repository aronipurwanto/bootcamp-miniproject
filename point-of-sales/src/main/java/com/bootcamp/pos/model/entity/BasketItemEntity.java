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
@Table(name = "tbl_basket_item")
public class BasketItemEntity {
    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "basket_date_time")
    private LocalDateTime basketDateTime;

    @Column(name = "quantity")
    private Double quantity;

    @Column(name = "cost")
    private Double cost;
}
