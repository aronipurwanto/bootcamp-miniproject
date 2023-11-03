package com.bootcamp.pos.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Date dateFrom;
    private Date dateTo;
}
