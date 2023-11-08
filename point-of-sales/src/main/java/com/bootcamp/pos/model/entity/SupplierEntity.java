package com.bootcamp.pos.model.entity;

import com.bootcamp.pos.model.request.SupplierRequest;
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
@Table(name = "tbl_supplier")
public class SupplierEntity {
    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "other_supplier_detail")
    private String otherSupplierDetail;

    @OneToMany(mappedBy = "supplier", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SupplierLocationEntity> supplierLocation = new ArrayList<>();

    public SupplierEntity(SupplierRequest request) {
        BeanUtils.copyProperties(request, this);
        this.id = UUID.randomUUID().toString();
    }
}
