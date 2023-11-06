package com.bootcamp.pos.model.response;

import com.bootcamp.pos.model.entity.SupplierEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierResponse {
    private String id;
    private String code;
    private String name;
    private String email;
    private Integer phone;
    private String otherSupplierDetail;

    public SupplierResponse(SupplierEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
