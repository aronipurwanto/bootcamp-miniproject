package com.bootcamp.pos.model.entity;

import com.bootcamp.pos.model.response.CustomerResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_customer")
public class CustomerEntity {
    @Id
    @Column(name = "customer_id")
    private String id;

//    //---------------Relasi ke Ref Payment------------//
//    @Column(name = "payment_code")
//    private String paymentCode;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name ="payment_code",insertable = false,updatable = false)
//    private RefPaymentEntity payment;
//    //---------------------------//

    @Column(name = "customer_name")
    private String name;

    @Column(name = "customer_phone")
    private String phone;

    @Column(name = "customer_email")
    private String email;

    @Column(name = "date_became_customer")
    private LocalDate date;

    @Column(name = "payment_details")
    private String paymentDetails;

    @Column(name = "other_customer_details")
    private String customerDetails;

    public CustomerEntity(CustomerResponse response) {
        BeanUtils.copyProperties(response, this);
        this.id = UUID.randomUUID().toString();

    }
}
