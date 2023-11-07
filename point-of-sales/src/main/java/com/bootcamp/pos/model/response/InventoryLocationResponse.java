package com.bootcamp.pos.model.response;

import com.bootcamp.pos.model.entity.InventoryLocationEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryLocationResponse {
    private String locationId;

    private String quantity;

    private String reorderLevel;

    private String reorderQuantity;

    private String totalAverage;

    private String inventoryDetails;

    public InventoryLocationResponse(InventoryLocationEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
