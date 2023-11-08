package com.bootcamp.pos.model.entity;

import com.bootcamp.pos.model.response.ShopBasketResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="tbl_shopping_basket")
public class ShoopingBasketEntity {
    @Id
    @Column(name = "id")
    private String id;

    //---------------Relasi ke Customer------------//
    @Column(name = "customer_id")
    private String customerId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id",insertable = false,updatable = false)
    private CustomerEntity customer;
    //---------------------------//

    @Column(name = "basket_date")
    private LocalDateTime dateTime;

    @Column(name ="total_cost")
    private String totalCost;

    @Column(name = "other_basket_details")
    private String details;

    public ShoopingBasketEntity(ShopBasketResponse response) {
        BeanUtils.copyProperties(response, this);
        this.id = UUID.randomUUID().toString();
    }
}
