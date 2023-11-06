package com.bootcamp.pos.model.response;

import com.bootcamp.pos.model.entity.CustomerEntity;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {

    private String id;
    //---------------Relasi ke Payment------------//
    //private String paymentCode;

    //---------------------------//

    private String name;

    private String phone;

    private String email;

    @DateTimeFormat(pattern = "yy-mm-dd")
    private LocalDate date;

    private String paymentDetails;

    private String customerDetails;

    public CustomerResponse(CustomerEntity entity) {
        BeanUtils.copyProperties(entity, this);
       // this.paymentCode = getPaymentCode();
    }
}
