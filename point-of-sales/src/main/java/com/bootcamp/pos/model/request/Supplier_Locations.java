package com.bootcamp.pos.model.request;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Supplier_Locations {

    private String id;

    private LocalDate dateFrom;

    private LocalDate dateTo;
}
