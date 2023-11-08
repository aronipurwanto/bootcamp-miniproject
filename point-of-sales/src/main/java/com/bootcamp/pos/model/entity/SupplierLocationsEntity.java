package com.bootcamp.pos.model.entity;

import com.bootcamp.pos.model.response.SupplierLocationResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_supplier_locations")
public class SupplierLocationsEntity {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "date_to")
    private LocalDate dateTo;

    public SupplierLocationsEntity(SupplierLocationResponse response) {
        BeanUtils.copyProperties(response, this);
        this.id= UUID.randomUUID().toString();
    }
}
