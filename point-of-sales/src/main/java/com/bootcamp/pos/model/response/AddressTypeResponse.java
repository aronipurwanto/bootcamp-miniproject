package com.bootcamp.pos.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressTypeResponse {
    private Long id;
    private String addressCode;
    private String addressDesc;
    private String billing;
    private String delivery;
}
