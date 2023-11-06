package com.bootcamp.pos.model.entity;

import com.bootcamp.pos.model.response.RefPaymentResponse;
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
@Table(name ="tbl_ref_payment_methods")
public class RefPaymentEntity {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name ="payment_method_code")
    private String code;

    @Column(name = "payment_method_description")
    private String desc;

    public RefPaymentEntity(RefPaymentResponse response) {
        BeanUtils.copyProperties(response, this);
        this.id = UUID.randomUUID().toString();
    }
}
