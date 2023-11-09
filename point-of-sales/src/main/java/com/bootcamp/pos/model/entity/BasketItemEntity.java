package com.bootcamp.pos.model.entity;

import com.bootcamp.pos.model.request.BasketItemRequest;
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
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "basket_date_time")
    private LocalDateTime basketDateTime;

    @Column(name = "quantity")
    private Double quantity;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "customer_id", length = 36)
    private String customerId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private CustomerEntity customer;

    @Column(name = "product_id", length = 36)
    private String productId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private ProductEntity product;

    public BasketItemEntity(BasketItemRequest request) {
        BeanUtils.copyProperties(request, this);
        this.id = UUID.randomUUID().toString();
    }
}
