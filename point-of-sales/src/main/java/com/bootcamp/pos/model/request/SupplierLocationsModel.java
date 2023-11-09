package com.bootcamp.pos.model.request;

import com.bootcamp.pos.model.entity.SupplierLocationsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierLocationsModel {
    private String id;

    private String supplierId;
    private SuppliersModel suppliers;

    private String addressId;
    private AddressModel address;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate dateFrom;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate dateTo;

    public SupplierLocationsModel(SupplierLocationsEntity entity) {
        BeanUtils.copyProperties(entity, this);

        if (entity.getSuppliers() != null){
            this.supplierId = entity.getSuppliers().getId();
            this.suppliers = new SuppliersModel(entity.getSuppliers());
        }
        if (entity.getAddress() != null){
            this.addressId = entity.getAddress().getId();
            this.address = new AddressModel(entity.getAddress());
        }
    }
}
