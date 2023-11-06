package com.bootcamp.pos.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_supplier_locations")
public class Supplier_Locations {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "date_form")
    private Date dateFrom;
    @Column(name = "date_to")
    private Date dateTo;
}
