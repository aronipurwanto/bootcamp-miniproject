package com.bootcamp.pos.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_shopping_basket")
public class ShoppingBasket {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "basket_date")
    private LocalDate basketDateTime;

    @Column(name = "total_cost")
    private Double totalCost;

    @Column(name = "other_details")
    private String otherDetails;
}
