package com.bootcamp.pos.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierLocationsRequest {
    private String id;
    private String supplierCode;
    private String addressId;
    private Date dateFromId;
    private Date dateTo;
}
