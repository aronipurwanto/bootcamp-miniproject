package com.bootcamp.pos.model.response;

import com.bootcamp.pos.model.entity.ProductSuppliersEntity;
import com.bootcamp.pos.model.request.ProductsModel;
import com.bootcamp.pos.model.request.SuppliersModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSuppliersResponse {
    private Long id;

    private String productId;
    private ProductsModel products;

    private String supplierId;
    private SuppliersModel suppliers;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
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

    public ProductSuppliersResponse(ProductSuppliersEntity entity) {
        BeanUtils.copyProperties(entity, this);

        if (entity.getProducts() != null){
            this.productId = entity.getProducts().getId();
            this.products = new ProductsModel(entity.getProducts());
        }
        if (entity.getSuppliers() != null){
            this.supplierId = entity.getSuppliers().getId();
            this.suppliers = new SuppliersModel(entity.getSuppliers());
        }
    }
}
