package com.bootcamp.pos.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductSuppliersRequest {

    private String id;

    private String supplierCode;

    private String valueSupplierToDate;

    private String totalQtySupplier;

    private String fitsItemSupDate;

    private String lastItemSupDate;

    private String deliveryLeadTime;

    private String standartPrice;

    private String percentDiscount;

    private String maxOrderQty;

    private String minOrderQty;

    private String itemSupDetails;
}
