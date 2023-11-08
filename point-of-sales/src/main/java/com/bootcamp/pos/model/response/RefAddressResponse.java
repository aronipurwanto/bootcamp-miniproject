package com.bootcamp.pos.model.response;

import com.bootcamp.pos.model.entity.RefAddressEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefAddressResponse {
    private String id;
    private String code;
    private String desc;
    public RefAddressResponse(RefAddressEntity refAddress) {
        BeanUtils.copyProperties(refAddress, this);
    }
}
