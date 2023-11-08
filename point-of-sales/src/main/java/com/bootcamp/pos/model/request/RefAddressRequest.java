package com.bootcamp.pos.model.request;

import com.bootcamp.pos.model.entity.RefAddressEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefAddressRequest {
    private String id;
    private String code;
    private String desc;
    public RefAddressRequest(RefAddressEntity refAddress) {
        BeanUtils.copyProperties(refAddress, this);
    }
}
