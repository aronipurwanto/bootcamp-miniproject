package com.bootcamp.pos.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefProductTypeRequest {
    private String productTypeCode;
    private String productTypeDescription;
    private String egFruitToy;
}
