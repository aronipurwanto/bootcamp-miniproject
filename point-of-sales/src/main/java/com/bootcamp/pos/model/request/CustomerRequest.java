package com.bootcamp.pos.model.request;

import com.bootcamp.pos.model.entity.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {
    private String id;
    private String paymentMethodCode;
    private String customerName;
    private String customerPhone;
    private String customerEmail;
    private String dateBecameCustomer;
    private String paymentDetails;

    public CustomerRequest(CustomerEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
