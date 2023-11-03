package com.bootcamp.pos.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_refpayment_method")
public class RefPaymentMethod {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "product_type_desc")
    private String productTypeDesc;

}
