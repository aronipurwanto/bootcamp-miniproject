package com.bootcamp.pos.model.request;

import com.bootcamp.pos.model.entity.AddressTypeEntity;
import com.bootcamp.pos.model.entity.ProductTypeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressTypeModel {
    private String id;
    private String addressCode;
    private String billing;
    private String delivery;

    public AddressTypeModel(AddressTypeEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
