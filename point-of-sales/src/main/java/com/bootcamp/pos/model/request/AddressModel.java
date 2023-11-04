package com.bootcamp.pos.model.request;

import com.bootcamp.pos.model.entity.AddressEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressModel {
    private String id;
    private String noHome;
    private String onStreet;
    private String village;
    private String subdistrict;
    private String city;
    private String province;
    private String country;
    private Integer postCode;

    public AddressModel(AddressEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}