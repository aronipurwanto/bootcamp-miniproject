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
public class BasketItems {
    @Id
    @TableGenerator(name = "tbl_basket_items_seq",
            table = "tbl_sequence",
            pkColumnName = "sequence_id",
            valueColumnName="sequence_value",
            pkColumnValue = "basket_items_id",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_basket_items_seq")
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", insertable = false,updatable = false)
    private CustomerEntity customerId;

    @Column(name = "basket_date", length = 100)
    private LocalDate basketDatetime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private ProductsEntity productId;

    @Column(name = "quantity", length = 60)
    private Double quantity;

    @Column(name = "cost")
    private Double cost;
}
