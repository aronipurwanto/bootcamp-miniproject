package com.bootcamp.pos.model.response;

import com.bootcamp.pos.model.entity.RefProductTypeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RefProductTypeResponse {

    private String id;

    private String code;

    private String desc;

    public RefProductTypeResponse(RefProductTypeEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
