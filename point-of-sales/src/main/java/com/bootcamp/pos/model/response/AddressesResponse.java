package com.bootcamp.pos.model.response;

import com.bootcamp.pos.model.entity.AddressesEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressesResponse {

    private String id;

    private String houseNumber;

    private String onStreet;

    private String village;

    private String subdistrict;

    private String city;

    private String postcode;

    private String province;

    private String country;

    private String addressDetails;

    public AddressesResponse(AddressesEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
