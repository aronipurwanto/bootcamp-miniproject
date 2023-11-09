package com.bootcamp.pos.model.request;

import com.bootcamp.pos.model.entity.AddressEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {
    private String id;
    private String codePos;
    private String namaJalan;
    private String nomorRumah;
    private String kelurahan;
    private String city;
    private String zipPostCode;
    private String stateProvinceCountry;
    private String country;
    private String otherAddressDetail;

    public AddressRequest(AddressEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
