package com.bootcamp.pos.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSuppliersRequest {
    private String productId;
    private String supplierCode;
    private String valueSuppliedToDate;
    private String totalQuantitySuppliedDate;
    private String firstItemSuppliedDate;
    private String lastItemSuppliedDate;
    private String deliveryLeadTime;
    private String standardPrice;
    private String percentageDiscount;
    private String minimumOrderQuantity;
    private String maximumOrderQuantity;
    private String otherItemSuppliersDetails;
}
