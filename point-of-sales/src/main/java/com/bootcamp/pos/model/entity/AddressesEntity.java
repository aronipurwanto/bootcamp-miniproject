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
    private Long id;

    @Column(name = "line_1")
    private String line1;

    @Column(name = "line_2")
    private String line2;

    @Column(name = "line_3")
    private String line3;

    @Column(name = "line_4")
    private String line4;

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
