package com.bootcamp.pos.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierLocationsRequest {
    private String supplierCode;
    private String addressId;
    private String dateFrom;
    private String dateTo;
}
