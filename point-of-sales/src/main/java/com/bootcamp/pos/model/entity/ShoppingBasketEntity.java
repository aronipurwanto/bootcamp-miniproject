package com.bootcamp.pos.model.entity;

import com.bootcamp.pos.model.request.ShoppingBasketRequest;
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

    public ShoppingBasketEntity(ShoppingBasketRequest request, CustomerEntity customer) {
        BeanUtils.copyProperties(request, this);
        this.id = UUID.randomUUID().toString();
        this.customer = customer;
    }
}
