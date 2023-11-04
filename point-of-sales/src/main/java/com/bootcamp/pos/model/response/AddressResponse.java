package com.bootcamp.pos.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String province;
    private String country;
    private Integer postCode;
}