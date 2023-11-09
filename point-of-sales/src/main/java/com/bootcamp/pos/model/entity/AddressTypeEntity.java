package com.bootcamp.pos.model.entity;

import com.bootcamp.pos.model.request.AddressTypeModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_address_type")
public class AddressTypeEntity {
    @Id
    @Column(name = "address_type_id")
    private String id;

    @Column(name = "address_code")
    private String addressCode;

    @Column(name = "billing")
    private String billing;

    @Column(name = "delivery_address")
    private String delivery;

    public AddressTypeEntity(AddressTypeModel model) {
        BeanUtils.copyProperties(model, this);
        this.id = UUID.randomUUID().toString();
    }
}
