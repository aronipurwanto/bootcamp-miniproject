package com.bootcamp.pos.model.request;

import com.bootcamp.pos.model.entity.SupplierLocationEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierLocationRequest {
    private String id;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate dateFrom;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate dateTo;
    private String  supplierId;
    private SupplierRequest supplier;
    private String addressId;
    private AddressRequest address;


    public SupplierLocationRequest(SupplierLocationEntity supplierLocation) {
        BeanUtils.copyProperties(supplierLocation, this);

        if (supplierLocation.getSupplier() != null){
            this.supplierId = supplierLocation.getSupplierId();
            this.supplier = new SupplierRequest(supplierLocation.getSupplier());
        }

        if (supplierLocation.getAddress() != null){
            this.addressId = supplierLocation.getAddressId();
            this.address = new AddressRequest(supplierLocation.getAddress());
        }
    }
}
