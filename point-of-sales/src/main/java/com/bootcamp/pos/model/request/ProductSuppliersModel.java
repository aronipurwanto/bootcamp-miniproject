package com.bootcamp.pos.model.request;

import com.bootcamp.pos.model.entity.ProductSuppliersEntity;
import com.bootcamp.pos.model.entity.ProductsEntity;
import com.bootcamp.pos.model.entity.SuppliersEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSuppliersModel {
    private String id;

    private String productId;
    private ProductsEntity products;

    private String supplierId;
    private SuppliersEntity suppliers;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate suppliedToDate;
    private String totalQtySupToDate;
    private String firstItemSupDate;
    private String lastItemSupDate;
    private String deliveryLeadTime;
    private String standardPrice;
    private String percentDiscount;
    private Integer minOrderQty;
    private Integer maxOrderQty;
    private String itemSuppliersDetails;

    public ProductSuppliersModel(ProductSuppliersEntity entity){
        BeanUtils.copyProperties(entity, this);
    }
}
