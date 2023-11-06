package com.bootcamp.pos.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {
    private String id;
    private String name;
    private String phone;
    private String email;
    private LocalDate date;
    private String paymentDetails;
    private String customerDetails;

}
