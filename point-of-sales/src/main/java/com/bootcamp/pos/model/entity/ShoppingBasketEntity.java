package com.bootcamp.pos.model.entity;

import com.bootcamp.pos.model.request.ShoppingBasketModel;
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
@Table(name = "tbl_shopping_basket")
public class ShoppingBasketEntity {
    @Id
    @Column(name = "shopping_basket_id")
    private String id;

    @Column(name = "basket_datetime")
    private LocalDateTime basketDatetime;

    @Column(name = "total_cost")
    private Integer totalCost;

    @Column(name = "bsaket_detail")
    private String basketDetail;

    @Column(name = "customer_id")
    private String customerId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private CustomerEntity customer;

    public ShoppingBasketEntity(ShoppingBasketModel model) {
        BeanUtils.copyProperties(model, this);
        this.id = UUID.randomUUID().toString();
    }
}
