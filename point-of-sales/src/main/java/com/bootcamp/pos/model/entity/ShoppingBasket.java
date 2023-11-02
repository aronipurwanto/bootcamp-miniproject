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
    @TableGenerator(name = "tbl_shopping_basket_seq",
            table = "tbl_sequence",
            pkColumnName = "sequence_id",
            valueColumnName="sequence_value",
            pkColumnValue = "shopping_basket_id",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_shopping_basket_seq")
    @Column(name = "id")
    private Long id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private CustomerEntity customerId;

    @Column(name = "basket_date")
    private LocalDate basketDatetime;

    @Column(name = "total_cost")
    private Double totalCost;

    @Column(name = "other_details")
    private String otherDetails;
}
