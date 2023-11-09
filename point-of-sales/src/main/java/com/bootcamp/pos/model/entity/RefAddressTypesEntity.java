package com.bootcamp.pos.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_ref_Address_Types")
public class RefAddressTypesEntity {

    @Id
    @Column(name = "address_type_code")
    private String addressTypeCode;

    @Column(name = "address_type_description")
    private String addressTypeDescription;

    @Column(name = "-egBilling_delivery_residential")
    private String egBillingDeliveryResidential;
}
