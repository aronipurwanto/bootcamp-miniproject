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

    private LocalDate valueSupplierToDate;

    private String totalQtySupplier;

    private String fitsItemSupDate;

    private String lastItemSupDate;

    private String deliveryLeadTime;

    private Integer standartPrice;

    private String percentDiscount;

    private Integer maxOrderQty;

    private Integer minOrderQty;

    private String itemSupDetails;
}
