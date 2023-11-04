package com.bootcamp.pos.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierLocationsModel {
    private Long supplierLocationId;
    private String supplierCode;
    private Long supplierId;
    private Long addressId;
    private Date dateForm;
    private Date dateTo;
}
