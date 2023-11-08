package com.bootcamp.pos.model.entity;

import com.bootcamp.pos.model.request.RefPaymentRequest;
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
@Table(name = "tbl_ref_payment")
public class RefPaymentEntity {
    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String desc;

    @OneToMany(mappedBy = "payment", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CustomerEntity> customerEntities = new ArrayList<>();

    public RefPaymentEntity(RefPaymentRequest request) {
        BeanUtils.copyProperties(request, this);
        this.id = UUID.randomUUID().toString();
    }
}
