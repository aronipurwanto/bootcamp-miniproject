package com.bootcamp.pos.model.entity;

import com.bootcamp.pos.model.request.AddressModel;
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
@Table(name = "tbl_address")
public class AddressEntity {
    @Id
    @Column(name = "address_id")
    private String id;

    @Column(name = "no_home")
    private String noHome;

    @Column(name = "on_street")
    private String onStreet;

    @Column(name = "village")
    private String village;

    @Column(name = "subdistrict")
    private String subdistrict;

    @Column(name = "city")
    private String city;

    @Column(name = "province")
    private String province;

    @Column(name = "country")
    private String country;

    @Column(name = "post_code")
    private Integer postCode;

    public AddressEntity(AddressModel model) {
        BeanUtils.copyProperties(model, this);
        this.id = UUID.randomUUID().toString();
    }
}