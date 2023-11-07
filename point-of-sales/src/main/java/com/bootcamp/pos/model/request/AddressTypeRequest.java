package com.bootcamp.pos.model.request;

import com.bootcamp.pos.model.entity.AddressTypeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressTypeRequest {

    private String id;
    private String addressCodeType;
    private String addressDescType;
    private String billing;
    private String delivery;

    public AddressTypeRequest(AddressTypeEntity result) {
        BeanUtils.copyProperties(result, this);
    }
}
