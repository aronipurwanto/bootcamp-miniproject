package com.bootcamp.pos.model.request;

import com.bootcamp.pos.model.entity.CustomerEntity;
import com.bootcamp.pos.model.entity.RefPaymentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefPaymentRequest {
    private String id;
    private String code;
    private String desc;
    private List<CustomerRequest> customerRequests = new ArrayList<>();

    public RefPaymentRequest(RefPaymentEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
