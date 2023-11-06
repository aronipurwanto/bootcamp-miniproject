package com.bootcamp.pos.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

    private String id;

    private String details;

    private String name;

    private String price;

    private String description;
}
