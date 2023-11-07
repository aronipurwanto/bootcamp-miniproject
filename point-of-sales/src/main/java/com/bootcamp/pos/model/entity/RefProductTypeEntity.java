package com.bootcamp.pos.model.entity;

import com.bootcamp.pos.model.response.RefProductTypeResponse;
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
@Table(name = "tbl_ref_product_types")
public class RefProductTypeEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "product_type_code")
    private String code;

    @Column(name = "product_type_description")
    private String desc;

    public RefProductTypeEntity(RefProductTypeResponse response) {
        BeanUtils.copyProperties(response, this);
        this.id = UUID.randomUUID().toString();
    }
}
