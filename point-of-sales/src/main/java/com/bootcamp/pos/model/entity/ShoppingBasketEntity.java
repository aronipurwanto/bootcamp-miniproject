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
@Table(name = "tbl_shopping_bakset")
public class ShoppingBasketEntity {
    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "customer_id")
    private String customerId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private CustomerEntity customer;

    @Column(name = "basket_date_time")
    private LocalDateTime basketDateTime;

    @Column(name = "total_cost")
    private Double totalCost;

    @Column(name = "other_basket_detail")
    private String otherBasketDetail;
}
