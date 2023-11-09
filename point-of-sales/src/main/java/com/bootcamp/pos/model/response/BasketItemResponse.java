package com.bootcamp.pos.model.response;

import com.bootcamp.pos.model.entity.BasketItemEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasketItemResponse {
    private String basketId;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDateTime basketDatetime;
    private Integer quantity;
    private String cost;
    private String customerId;
    private String productId;
}
