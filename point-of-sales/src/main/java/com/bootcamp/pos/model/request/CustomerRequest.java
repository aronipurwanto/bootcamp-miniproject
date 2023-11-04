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
    private Long customerPhone;
    private String customerEmail;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate dateOrder;
    private Integer paymentDetails;
    private String customerDetails;
    private String paymentMethod;

    public CustomerRequest(CustomerEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
