package com.bootcamp.pos.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="tbl_addresses")
public class AddressesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long Addressid;



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
}
