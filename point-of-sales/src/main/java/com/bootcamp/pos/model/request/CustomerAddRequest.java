package com.bootcamp.pos.model.request;

import com.bootcamp.pos.model.entity.CustomerAddressEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAddRequest {
    private String id;
    private String customerId;
    private CustomerRequest customer;
    private String addressId;
    private AddressRequest address;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate dateFrom;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate dateTo;

    public CustomerAddRequest(CustomerAddressEntity entity) {
        BeanUtils.copyProperties(entity, this);

        if (entity.getCustomer() != null){
            this.customerId = entity.getCustomerId();
            this.customer = new CustomerRequest(entity.getCustomer());
        }

        if (entity.getAddress() != null){
            this.addressId = entity.getAddressId();
            this.address = new AddressRequest(entity.getAddress());
        }
    }
}
