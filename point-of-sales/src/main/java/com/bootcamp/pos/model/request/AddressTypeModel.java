package com.bootcamp.pos.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressTypeModel {
    private Long id;
    private String addressCode;
    private String addressDesc;
    private String billing;
    private String delivery;
}
