package com.bootcamp.pos.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefAddressTypeRequest {

    private String id;
    private String addressTypeCode;
    private String addressDescType;
}
