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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    //--------Relasi ke Customer--------//
    @Column(name = "customer_id")
    private Long customerId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
    //----------------//


    //--------Relasi ke Shooping_Basket--------//
    @Column(name = "basket_datetime")
    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="basket_datetime")
    private ShoopingBasketEntity shoopingBasket;
    //----------------//


    //--------Relasi ke Product--------//
    @Column(name = "product_id")
    private Long productId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="product_id")
    private ProductEntity product;
    //----------------//


    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "cost")
    private Integer cost;
}
