package com.bootcamp.pos.model.request;

import com.bootcamp.pos.model.entity.CustomerAddressEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.PrimaryKey;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAddressRequest {
    private String id;
    private String customerId;
    private CustomerRequest customer;
    private String addressId;
    private AddressRequest address;
    private String dateFrom;
    private String addressTypeCodeDateTo;


    public CustomerAddressRequest(CustomerAddressEntity entity) {
        BeanUtils.copyProperties(entity, this);

        if (entity.getCustomer() != null){
            this.customerId = entity.getCustomerId();
            this.customer = new CustomerRequest(entity.getCustomer());
        }
        if (entity.getAddress() != null){
            this.addressId = entity.getAddressId();
            this.address = new AddressRequest(entity.getAddress());
        }
    }
}
