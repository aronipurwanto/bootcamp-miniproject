package com.bootcamp.pos.model.request;


import com.bootcamp.pos.model.entity.CustomerAddressEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAddressModel {
    private String id;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate dateFrom;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate dateTo;
    private String addressType;

    private String customerId;
    private CustomerRequest customer;

    private String addressId;
    private AddressModel address;

    public CustomerAddressModel(CustomerAddressEntity entity) {
        BeanUtils.copyProperties(entity, this);

        if (entity.getCustomer() != null){
            this.customerId = entity.getCustomer().getId();
            this.customer = new CustomerRequest(entity.getCustomer());
        }
        if (entity.getAddress() != null){
            this.addressId = entity.getAddress().getId();
            this.address = new AddressModel(entity.getAddress());
        }
    }
}
