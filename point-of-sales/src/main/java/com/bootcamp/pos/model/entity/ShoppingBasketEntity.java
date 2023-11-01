package com.bootcamp.pos.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_shopping_basket")
public class ShoppingBasketEntity {
    @Id
    @TableGenerator(name = "tbl_shopping_basket_seq",
            table = "tbl_sequence",
            pkColumnName = "sequence_id",
            valueColumnName = "sequence_value",
            pkColumnValue = "shopping_basket_id",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_shopping_basket_seq")
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

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private CustomerEntity customer;
}
