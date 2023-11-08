package com.bootcamp.pos.model.response;

import com.bootcamp.pos.model.entity.RefPaymentEntity;
import com.bootcamp.pos.model.request.CustomerRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefPaymentResponse {
    private String id;
    private String code;
    private String desc;
    private List<CustomerRequest> customerRequests = new ArrayList<>();

    public RefPaymentResponse(RefPaymentEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
