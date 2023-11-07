package com.bootcamp.pos.model.response;

import com.bootcamp.pos.model.entity.ProductSuppliersEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSuppliersResponse {

    private String id;

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

    public ProductSuppliersResponse(ProductSuppliersEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
