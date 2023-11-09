package com.bootcamp.pos.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierRequest {
    private String supplierCode;
    private String supplierName;
    private String supplierAddress;
    private String supplierEmail;
    private String supplierPhone;
}
