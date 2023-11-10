package com.bootcamp.pos.model.response;

import com.bootcamp.pos.model.entity.SupplierLocationsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierLocationResponse {
    private String id;

    private String supplierId;
    private String supplierCode;

    private String addressid;
    private String addressDetails;

    private String cusaddressId;
    private LocalDate dateFrom;

    @DateTimeFormat(pattern = "yy-MM-dd")
    private LocalDate dateTo;

    public SupplierLocationResponse(SupplierLocationsEntity entity) {
        BeanUtils.copyProperties(entity, this) ;
        if(entity.getSuppliers() != null){
            supplierId = entity.getSupplierId();
            supplierCode = entity.getSuppliers().getCode();
        }
        if(entity.getAddresses() != null){
            addressid = entity.getAddressid();
            addressDetails = entity.getAddresses().getAddressDetails();
        }
        if(entity.getCustomerAddress() != null){
            cusaddressId = entity.getCusaddressId();
            dateFrom = entity.getCustomerAddress().getDateFrom();
        }


    }
}
