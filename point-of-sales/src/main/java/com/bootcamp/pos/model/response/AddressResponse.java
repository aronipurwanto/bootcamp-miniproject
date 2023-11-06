
package com.bootcamp.pos.model.response;

import com.bootcamp.pos.model.entity.AddressEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponse {
    private String id;
    private String noHome;
    private String onStreet;
    private String village;
    private String subdistrict;
    private String city;
    private String zipPostCode;
    private String stateProvinceCountry;
    private String country;
    private String otherAddressDetail;

    public AddressResponse(AddressEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
