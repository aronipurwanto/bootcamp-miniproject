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

    private String supLocId;
    private SupplierLocationsModel supplierLocations;

    private String customerId;
    private CustomerRequest customer;

    private String addressId;
    private AddressModel address;

    private String addressTypeId;
    private AddressTypeModel addressType;
    @DateTimeFormat(pattern = "yyyy-dd-mm")
    private LocalDate dateTo;

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
        if (entity.getAddressType() != null){
            this.addressTypeId = entity.getAddressType().getId();
            this.addressType = new AddressTypeModel(entity.getAddressType());
        }
        if (entity.getSupplierLocations() != null){
            this.supLocId = entity.getSupplierLocations().getId();
            this.supplierLocations = new SupplierLocationsModel(entity.getSupplierLocations());
        }
    }
}
