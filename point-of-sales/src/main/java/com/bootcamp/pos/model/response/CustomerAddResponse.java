package com.bootcamp.pos.model.response;

import com.bootcamp.pos.model.entity.CustomerAddressEntity;
import com.bootcamp.pos.model.request.AddressRequest;
import com.bootcamp.pos.model.request.CustomerRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAddResponse {
    private String id;
    private String customerId;
    private CustomerRequest customer;
    private String addressId;
    private AddressRequest address;
    private Date dateFrom;
    private Date dateTo;

    public CustomerAddResponse(CustomerAddressEntity entity) {
        BeanUtils.copyProperties(entity, this);

    }
}
