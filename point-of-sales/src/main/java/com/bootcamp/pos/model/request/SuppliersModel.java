package com.bootcamp.pos.model.request;

import com.bootcamp.pos.model.entity.SuppliersEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuppliersModel {
    private String id;
    private String supplierCode;
    private String supplierName;
    private String supplierAddress;
    private String supplierEmail;
    private String supplierPhone;
    private String supplierDetails;

    public SuppliersModel(SuppliersEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
