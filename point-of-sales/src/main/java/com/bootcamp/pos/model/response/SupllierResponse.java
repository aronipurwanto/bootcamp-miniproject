package com.bootcamp.pos.model.response;

import com.bootcamp.pos.model.entity.SuppliersEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SupllierResponse {

    private String id;

    private String code;

    private String name;

    private String address;

    private String email;

    private String phone;

    private String supDetails;

    public SupllierResponse(SuppliersEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
