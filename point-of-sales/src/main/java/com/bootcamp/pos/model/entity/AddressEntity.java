package com.bootcamp.pos.model.entity;

import com.bootcamp.pos.model.request.AddressRequest;
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
    @Column(name = "id")
    private String id;

    @Column(name = "code_pos")
    private String codePos;

    @Column(name = "nama_jalan")
    private String namaJalan;

    @Column(name = "nomor_rumah")
    private String nomorRumah;

    @Column(name = "kelurahan")
    private String kelurahan;

    @Column(name = "city")
    private String city;

    @Column(name = "zip_postcode")
    private String zipPostCode;

    @Column(name = "state_provice_county")
    private String stateProvinceCountry;

    @Column(name = "country")
    private String country;

    @Column(name = "other_address_details")
    private String otherAddressDetail;

    public AddressEntity(AddressRequest request) {
        BeanUtils.copyProperties(request, this);
        this.id = UUID.randomUUID().toString();
    }
}
