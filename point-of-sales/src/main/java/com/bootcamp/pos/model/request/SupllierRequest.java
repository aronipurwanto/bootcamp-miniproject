package com.bootcamp.pos.model.request;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SupllierRequest {
    private String id;

    private String code;

    private String name;

    private String address;

    private String email;

    private String phone;

    private String supDetails;
}
