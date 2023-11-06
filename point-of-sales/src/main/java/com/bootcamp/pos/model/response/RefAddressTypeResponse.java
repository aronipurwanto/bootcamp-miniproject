package com.bootcamp.pos.model.response;

import com.bootcamp.pos.model.entity.RefAddressTypeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefAddressTypeResponse {

    private String id;

    private String code;

    private String desc;

    public RefAddressTypeResponse(RefAddressTypeEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
