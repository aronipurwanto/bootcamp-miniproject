package com.bootcamp.pos.model.request;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefAddressTypeRequest {

    private String id;

    private String code;

    private String desc;


}
