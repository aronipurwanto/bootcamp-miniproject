package com.bootcamp.pos.model.response;

import com.bootcamp.pos.model.entity.RefPaymentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RefPaymentResponse {

    private String id;

    private String code;

    private String desc;

    public RefPaymentResponse(RefPaymentEntity entity)   {
        BeanUtils.copyProperties(entity, this);
    }
}
