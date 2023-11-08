package com.bootcamp.pos.model.response;

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
public class    CustomerAddressResponse {

    private String id;

    //---------------Relasi ke customer------------//
    private String customerId;

    private String customerName;
    //---------------------------//


    //---------------Relasi ke address------------//
    private String addressId;

    private String houseNumber;
    //---------------------------//

    //---------------Relasi ke ref address type------------//
    private String addressTypeCode;

    private String code;
    //---------------Relasi ke ref address type------------//


    @DateTimeFormat(pattern = "yy-mm-dd")
    private LocalDate dateFrom;
    @DateTimeFormat(pattern = "yy-mm-dd")
    private LocalDate dateTo;

    public CustomerAddressResponse(CustomerAddressEntity entity) {
        BeanUtils.copyProperties(entity, this);
        addressTypeCode = entity.getAddressTypeCode();
        code = entity.getRefAddressType().getCode();
        addressId = entity.getAddressId();
        houseNumber = entity.getAddresses().getHouseNumber();
        customerId = entity.getCustomerId();
        customerName = entity.getCustomer().getName();
    }
}
