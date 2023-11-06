package com.bootcamp.pos.model.request;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ShoopingBasketEntity {

    private String id;

    private LocalDateTime dateTime;

    private Integer totalCost;

    private String details;
}
