package com.bootcamp.pos.model.response;

import com.bootcamp.pos.model.entity.AddressTypeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressTypeResponse {
    private String id;
    private String addressCode;
    private String addressDesc;
    private String billing;
    private String delivery;

    public AddressTypeResponse(AddressTypeEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
