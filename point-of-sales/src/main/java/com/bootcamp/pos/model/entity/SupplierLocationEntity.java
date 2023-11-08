package com.bootcamp.pos.model.entity;

import com.bootcamp.pos.model.request.SupplierLocationRequest;
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
@Table(name = "tbl_supplier_location")
public class SupplierLocationEntity {
    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "date_from")
    private LocalDate dateFrom;

    @Column(name = "date_to")
    private LocalDate dateTo;

    @Column(name = "address_id", length = 36)
    private String addressId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", insertable = false, updatable = false)
    private AddressEntity address;

    @Column(name = "supplier_id", length = 36)
    private String  supplierId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supplier_id", insertable = false, updatable = false)
    private SupplierEntity supplier;

    public SupplierLocationEntity(SupplierLocationRequest request, SupplierEntity supplier) {
        BeanUtils.copyProperties(request, this);
        this.id = UUID.randomUUID().toString();
        this.supplier = supplier;
    }
}
