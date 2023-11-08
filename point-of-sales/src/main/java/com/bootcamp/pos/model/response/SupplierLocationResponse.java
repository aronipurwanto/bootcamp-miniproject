package com.bootcamp.pos.model.response;

import com.bootcamp.pos.model.entity.SupplierLocationsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierLocationResponse {
    private String id;
    @DateTimeFormat(pattern = "yy-MM-dd")
    private LocalDate dateTo;

    public SupplierLocationResponse(SupplierLocationsEntity entity) {
        BeanUtils.copyProperties(entity, this) ;
    }
}
