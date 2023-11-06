package com.bootcamp.pos.service.impl;

import com.bootcamp.pos.model.entity.AddressesEntity;
import com.bootcamp.pos.model.entity.CustomerAddressEntity;
import com.bootcamp.pos.model.response.AddressesResponse;
import com.bootcamp.pos.model.response.CustomerAddressResponse;
import com.bootcamp.pos.repository.CustomerAddressRepo;
import com.bootcamp.pos.service.CustomerAddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerAddressServiceImpl implements CustomerAddressService {
    private final CustomerAddressRepo customerAddressRepo;
    @Override
    public List<CustomerAddressResponse> getAll() {
        return customerAddressRepo.findAll().stream().map(CustomerAddressResponse::new).collect(Collectors.toList());
    }

    @Override
    public Optional<CustomerAddressResponse> getById(String id) {
        CustomerAddressEntity result = this.customerAddressRepo.findById(id).orElse(null);
        if(result == null){
            return Optional.empty();
        }
        return Optional.of(new CustomerAddressResponse(result));
    }

    @Override
    public Optional<CustomerAddressResponse> save(CustomerAddressResponse request) {
        if(request == null){
            return Optional.empty();
        }
        CustomerAddressEntity entity = new CustomerAddressEntity(request);
        try{
            customerAddressRepo.save(entity);
            log.info("Save CusAddress to database success");
            return Optional.of(new CustomerAddressResponse(entity));
        }catch (Exception e){
            log.error("Save CusAddress to database failed, error: {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<CustomerAddressResponse> update(CustomerAddressResponse request, String id) {
        CustomerAddressEntity entity = customerAddressRepo.findById(id).orElse(null);
        if(entity == null){
            log.warn("CusAddress dengan id: {} tidak ada",id);
            return Optional.empty();
        }
        BeanUtils.copyProperties(request, entity);
        try{
            customerAddressRepo.save(entity);
            log.info("Update CusAaddress to database success");
            return Optional.of(new CustomerAddressResponse(entity));
        }catch (Exception e){
            log.error("Update CusAddress to database failed, error: {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<CustomerAddressResponse> delete(String id) {
        CustomerAddressEntity entity = customerAddressRepo.findById(id).orElse(null);
        if(entity == null){
            return Optional.empty();
        }
        try{
            customerAddressRepo.delete(entity);
            log.info("Delete CusAddress from database success");
            return Optional.of(new CustomerAddressResponse(entity));
        }catch (Exception e){
            log.error("Delete CusAddress from database failed, error: {}",e.getMessage());
            return Optional.empty();
        }
    }
}
