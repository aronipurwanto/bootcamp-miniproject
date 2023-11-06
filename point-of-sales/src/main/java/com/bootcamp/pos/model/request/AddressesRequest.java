package com.bootcamp.pos.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressesRequest {

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
}
