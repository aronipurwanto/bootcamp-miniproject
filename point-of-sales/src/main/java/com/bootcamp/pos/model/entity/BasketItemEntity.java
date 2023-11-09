package com.bootcamp.pos.model.entity;

import com.bootcamp.pos.model.request.BasketItemModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_basket_item")
public class BasketItemEntity {
    @Id
    @Column(name = "basket_item_id")
    private String id;

    @Column(name = "basket_datetime")
    private LocalDateTime basketDatetime;

    @Column(name = "basket_quantity")
    private Integer quantity;

    @Column(name = "cost")
    private String cost;

    @Column(name = "product_id")
    private String productId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private ProductsEntity products;

    @Column(name = "customer_id")
    private String customerId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private CustomerEntity customer;

    public BasketItemEntity(BasketItemModel model) {
        BeanUtils.copyProperties(model, this);
        this.id = UUID.randomUUID().toString();
    }
}
