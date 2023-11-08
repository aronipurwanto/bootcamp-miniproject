package com.bootcamp.pos.model.entity;

import com.bootcamp.pos.model.request.RefAddressRequest;
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
@Table(name = "tbl_ref_address")
public class RefAddressEntity {
    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String desc;

    @OneToMany(mappedBy = "refAddress", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CustomerAddressEntity> addressEntities = new ArrayList<>();

    public RefAddressEntity(RefAddressRequest request) {
        BeanUtils.copyProperties(request, this);
        this.id = UUID.randomUUID().toString();
    }
}
