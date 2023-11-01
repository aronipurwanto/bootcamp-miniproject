package com.bootcamp.pos.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefAddressTypeEntity {
    @Id
    @Column(name = "address_type_code")
    private String code;

    @Column(name = "address_type_description")
    private String desc;

}
