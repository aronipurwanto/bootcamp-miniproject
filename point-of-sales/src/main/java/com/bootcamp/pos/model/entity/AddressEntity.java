package com.bootcamp.pos.model.entity;

import com.bootcamp.pos.model.request.AddressRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_address")
public class AddressEntity {
    @Id
    @Column(name = "id", length = 36)
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

    @Column(name = "zip_post_code")
    private String zipPostCode;

    @Column(name = "state_province_country")
    private String stateProvinceCountry;

    @Column(name = "country")
    private String country;

    @Column(name = "other_address_detail")
    private String otherAddressDetail;

    @OneToMany(mappedBy = "address", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InventoryLocationsEntity> inventory = new ArrayList<>();

    public AddressEntity(AddressRequest request) {
        BeanUtils.copyProperties(request, this);
        this.id = UUID.randomUUID().toString();
    }
}
