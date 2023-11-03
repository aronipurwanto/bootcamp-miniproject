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
    private String customerName;
    private String customerPhone;
    private String customerEmail;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate dateCustomer;
    private String paymentDetails;
    private String otherCustomerDetails;

    public CustomerRequest(CustomerEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
