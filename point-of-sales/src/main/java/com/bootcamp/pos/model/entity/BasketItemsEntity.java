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


//---------------Relasi ke Customer------------//
    @Column(name = "customerr_id")
    private String customerId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="customerr_id",insertable = false,updatable = false)
    private CustomerEntity customer;
   //---------------------------//

    //---------------Relasi ke Shopping Basket------------//
    @Column(name = "basket_datetime")
    private String basketDtmId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "basket_datetime",insertable = false,updatable = false)
    private ShoopingBasketEntity shoopingBasket;
    //---------------------------//

    //---------------Relasi ke Product------------//
    @Column(name = "productt_id")
    private String producttId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productt_id", insertable = false, updatable = false )
    private ProductEntity product;
    //---------------------------//

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "cost")
    private String cost;


    public BasketItemsEntity(BasketItemsResponse response) {
        BeanUtils.copyProperties(response,this);
        this.id = UUID.randomUUID().toString();
    }
}
