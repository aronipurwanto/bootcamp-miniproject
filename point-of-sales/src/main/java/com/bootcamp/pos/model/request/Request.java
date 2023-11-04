package com.bootcamp.pos.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    private Long id;

    private String paymentCode;

    private String name;

    private Integer phone;

    private String email;

    private Date date;

    private String paymentDetails;

    private String customerDetails;
}
