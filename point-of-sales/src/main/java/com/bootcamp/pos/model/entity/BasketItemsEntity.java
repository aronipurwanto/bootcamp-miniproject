package com.bootcamp.pos.model.entity;

import com.bootcamp.pos.model.response.BasketItemsResponse;
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
@Table(name = "tbl_basket_items")

public class BasketItemsEntity {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "cost")
    private String cost;


    public BasketItemsEntity(BasketItemsResponse response) {
        BeanUtils.copyProperties(response,this);
        this.id = UUID.randomUUID().toString();
    }
}
