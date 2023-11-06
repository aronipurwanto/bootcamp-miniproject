package com.bootcamp.pos.model.response;

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
public class CustomerResponse {
    private String id;
    private String name;
    private String phone;
    private String email;
    @DateTimeFormat(pattern ="yyyy-mm-dd")
    private LocalDate dateBecame;
    private String paymentDetail;
    private String otherCustomerDetail;

    public CustomerResponse(CustomerEntity customer) {
        BeanUtils.copyProperties(customer, this);
    }
}
