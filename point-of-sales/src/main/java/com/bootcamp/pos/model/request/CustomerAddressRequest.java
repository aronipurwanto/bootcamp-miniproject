package com.bootcamp.pos.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAddressRequest {

    private String id;

    private LocalDate dateFrom;

    private LocalDate dateTo;

}
