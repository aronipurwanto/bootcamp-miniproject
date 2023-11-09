package com.bootcamp.pos.model.response;

import com.bootcamp.pos.model.request.AddressModel;
import com.bootcamp.pos.model.request.SuppliersModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierLocationsResponse {
    private String id;

    private String supplierId;
    private SuppliersModel suppliers;

    private String addressId;
    private AddressModel address;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate dateFrom;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate dateTo;
}
