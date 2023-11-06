package com.bootcamp.pos.model.entity;

import com.bootcamp.pos.model.response.AddressesResponse;
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
@Table(name ="tbl_addresses")
public class AddressesEntity {

    @Id
    @Column(name = "address_id")
    private String id;

    @Column(name = "No_Rumh")
    private String houseNumber;

    @Column(name = "nama_jalan")
    private String onStreet;

    @Column(name = "nama_desa")
    private String village;

    @Column(name = "subdistrict")
    private String subdistrict;

    @Column(name = "city")
    private String city;

    @Column(name = "zip_postcode")
    private String postcode;

    @Column(name = "state_province_county")
    private String province;

    @Column(name = "country")
    private String country;

    @Column(name = "other_address_details")
    private String addressDetails;

    public AddressesEntity(AddressesResponse response) {
        BeanUtils.copyProperties(response, this);
        this.id = UUID.randomUUID().toString();
    }
}
