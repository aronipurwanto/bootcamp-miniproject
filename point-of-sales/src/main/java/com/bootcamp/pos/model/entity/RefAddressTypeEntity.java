package com.bootcamp.pos.model.entity;

import com.bootcamp.pos.model.response.RefAddressTypeResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_refAddressType")
public class RefAddressTypeEntity {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name ="address_code")
    private String code;

    @Column(name = "address_description")
    private String desc;

    public RefAddressTypeEntity(RefAddressTypeResponse respon) {
        BeanUtils.copyProperties(respon, this);
        this.id= UUID.randomUUID().toString();
    }
}
