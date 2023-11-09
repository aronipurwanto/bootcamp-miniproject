package com.bootcamp.pos.model.request;

import com.bootcamp.pos.model.entity.ProductSuppliersEntity;
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
    private ProductsModel products;

    private String suppliersId;
    private SuppliersModel suppliers;

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

        if (entity.getProducts() != null){
            this.productId = entity.getProducts().getId();
            this.products = new ProductsModel(entity.getProducts());
        }
        if (entity.getSuppliers() != null){
            this.suppliersId = entity.getSuppliers().getId();
            this.suppliers = new SuppliersModel(entity.getSuppliers());
        }
    }
}
