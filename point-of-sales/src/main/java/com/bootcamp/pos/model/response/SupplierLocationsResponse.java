package com.bootcamp.pos.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierLocationsResponse {
    private String id;
    private String supplierCodeId;
    private String addressId;
    private Date dateFromId;
    private Date dateTo;
}
