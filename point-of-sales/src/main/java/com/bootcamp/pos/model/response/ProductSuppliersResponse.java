package com.bootcamp.pos.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSuppliersResponse {
    private Long productSupplierId;
    private Long productId;
    private String supplierCode;
    private Long supplierId;
    private Date suppliedToDate;
    private String totalQtySupToDate;
    private String firstItemSupDate;
    private String lastItemSupDate;
    private String deliveryLeadTime;
    private Integer standardPrice;
    private String percentDiscount;
    private Integer minOrderQty;
    private Integer maxOrderQty;
    private String itemSuppliersDetails;
}
