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
@Table(name = "shopping_basket")
public class ShoppingBasketEntity {
    @Id
    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "basket_datetime")
    private String basketDateTime;

    @Column(name = "total_cost")
    private String totalCost;

    @Column(name = "other_basket_details")
    private  String otherBasketDetails;
}
