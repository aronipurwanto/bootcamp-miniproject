package com.bootcamp.pos.sImpl;

import com.bootcamp.pos.model.entity.CustomerAddressEntity;
import com.bootcamp.pos.model.request.CustomerAddressModel;
import com.bootcamp.pos.repository.CustomerAddressRepository;
import com.bootcamp.pos.service.CustomerAddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerAddressServiceImpl implements CustomerAddressService {
    private final CustomerAddressRepository customerAddressRepository;
    @Override
    public List<CustomerAddressModel> getAll() {
        return this.customerAddressRepository.findAll()
                .stream()
                .map(CustomerAddressModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerAddressModel getById(String id) {
        return customerAddressRepository.findById(id)
                .map(CustomerAddressModel::new)
                .orElse(null);
    }

    @Override
    public Optional<CustomerAddressModel> save(CustomerAddressModel request) {
        if (request == null){
            return Optional.empty();
        }

        CustomerAddressEntity entity = new CustomerAddressEntity(request);
        try {
            this.customerAddressRepository.save(entity);
            log.info("Save Customer Address to database success");
            return Optional.of(new CustomerAddressModel(entity));
        }catch (Exception e){
            log.error("Save Customer Address to database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<CustomerAddressModel> update(CustomerAddressModel request, String id) {
        CustomerAddressEntity entity = this.customerAddressRepository.findById(id).orElse(null);
        if (entity == null){
            return Optional.empty();
        }

        BeanUtils.copyProperties(request, entity);
        try {
            customerAddressRepository.save(entity);
            log.info("Update Customer Address success");
            return Optional.of(new CustomerAddressModel(entity));
        }catch (Exception e){
            log.error("Update Customer Address failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<CustomerAddressModel> delete(String id) {
        CustomerAddressEntity result = this.customerAddressRepository.findById(id).orElse(null);
        if (result == null){
            log.warn("data customer address with id: {} not found", id);
            return Optional.empty();
        }

        try{
            customerAddressRepository.delete(result);
            log.info("Delete Customer Address from database success");
            return Optional.of(new CustomerAddressModel(result));
        }catch (Exception e){
            log.error("Delete Customer Address from database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }
}
