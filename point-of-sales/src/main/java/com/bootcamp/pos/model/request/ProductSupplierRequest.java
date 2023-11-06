package com.bootcamp.pos.model.request;

import com.bootcamp.pos.model.entity.ProductSupplierEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSupplierRequest {
    private  String id;
    private String code;
    private Date valueSupplied;
    private String totalQuantitySupplied;
    private String firstItemSupplied;
    private String lastItemSupplied;
    private String deliveryLead;
    private Double standardPrice;
    private String percentageDiscount;
    private Double minimumOrderQuantity;
    private Double maximumOrderQuantity;
    private String otherItemSupplierDetail;
    private String productId;
    private ProductRequest product;
    private String supplierId;
    private SupplierRequest supplier;

    public ProductSupplierRequest(ProductSupplierEntity entity) {
        BeanUtils.copyProperties(entity, this);

        if (entity.getProduct() != null){
            this.productId = entity.getProductId();
            this.product = new ProductRequest(entity.getProduct());
        }

        if (entity.getSupplier() != null){
            this.supplierId = entity.getSupplierId();
            this.supplier = new SupplierRequest(entity.getSupplier());
        }
    }
}
