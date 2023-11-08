package com.bootcamp.pos.model.request;

import com.bootcamp.pos.model.entity.SupplierEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierRequest {
    private String id;
    private String code;
    private String name;
    private String email;
    private String phone;
    private String otherSupplierDetail;
    private List<SupplierLocationRequest> supplierLocation = new ArrayList<>();

    public SupplierRequest(SupplierEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
