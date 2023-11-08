package com.bootcamp.pos.model.entity;

import com.bootcamp.pos.model.request.RefProductRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NegativeOrZero;
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
@Table(name = "tbl_ref_product")
public class RefProductEntity {
    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String desc;

    @OneToMany(mappedBy = "refProduct", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductEntity> product = new ArrayList<>();

    public RefProductEntity(RefProductRequest request) {
        BeanUtils.copyProperties(request, this);
        this.id = UUID.randomUUID().toString();
    }
}
