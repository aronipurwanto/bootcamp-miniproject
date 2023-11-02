package com.bootcamp.pos.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_address")
public class AddressEntity {
    @Id
    @TableGenerator(name = "tbl_address_seq",
            table = "tbl_sequence",
            pkColumnName = "sequence_id",
            valueColumnName = "sequence_value",
            pkColumnValue = "address_id",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_address_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "no", length = 60)
    private String no;

    @Column(name = "street", length = 60)
    private String street;

    @Column(name = "village", length = 60)
    private String village;

    @Column(name = "city", length = 100)
    private String city;

    @Column(name = "sub_district", length = 100)
    private String subDistrict;

    @Column(name = "regency", length = 100)
    private String regency;

    @Column(name = "province", length = 100)
    private String province;

    @Column(name = "country", length = 100)
    private String country;

    @Column(name = "postal_code", length = 100)
    private String postalCode;

    @Column(name = "other_details", length = 100)
    private String otherDetails;
}
