package com.bootcamp.pos.model.request;

import com.bootcamp.pos.model.entity.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {
    private String id;
    private String name;
    private String phone;
    private String email;
    @DateTimeFormat(pattern ="yyyy-mm-dd")
    private LocalDate dateBecame;
    private String paymentDetail;
    private String otherCustomerDetail;
    private String paymentId;
    private RefPaymentRequest payment;

    public CustomerRequest(CustomerEntity entity) {
        BeanUtils.copyProperties(entity, this);

        if (entity.getPayment() != null){
            this.paymentId = entity.getPaymentId();
            this.payment = new RefPaymentRequest(entity.getPayment());
        }
    }
}
