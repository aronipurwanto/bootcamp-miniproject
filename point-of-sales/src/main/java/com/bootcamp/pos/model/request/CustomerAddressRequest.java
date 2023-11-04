package com.bootcamp.pos.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAddressRequest {

    private Long id;

    private Long customerId;

    private Long addressId;

    private Date dateFrom;

    private Date dateTo;

}
