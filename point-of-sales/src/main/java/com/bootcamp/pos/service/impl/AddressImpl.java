package com.bootcamp.pos.service.impl;

import com.bootcamp.pos.model.request.AddressRequest;
import com.bootcamp.pos.model.entity.AddressEntity;
import com.bootcamp.pos.repository.AddressRepo;
import com.bootcamp.pos.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AddressImpl implements AddressService {
    private final AddressRepo addressRepo;

    public AddressImpl(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    @Override
    public List<AddressRequest> getAll() {
        return this.addressRepo.findAll().stream().map(AddressRequest::new).collect(Collectors.toList());
    }

    @Override
    public AddressRequest getById(String id) {
        if (id == null){
            new AddressRequest();
        }
        return this.addressRepo.findById(id).map(AddressRequest::new).orElse(new AddressRequest());
    }

    @Override
    public Optional<AddressRequest> save(AddressRequest request) {
        if (request == null){
            return Optional.empty();
        }
        AddressEntity entity = new AddressEntity(request);

        try {
            addressRepo.save(entity);
            log.info("save address to database successfully");
            return Optional.of(new AddressRequest(entity));
        }catch (Exception ex){
            log.error("save address to database failed, error:{}", ex.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<AddressRequest> update(AddressRequest request, String id) {
        AddressEntity entity = addressRepo.findById(id).orElse(null);
        if (entity == null){
            log.warn("address with id: {}, not fount", id);
            return Optional.empty();
        }
        BeanUtils.copyProperties(request, entity);

        try {
            addressRepo.save(entity);
            log.info("update address to database successfully");
            return Optional.of(new AddressRequest(entity));
        }catch (Exception ex){
            log.error("update address to database failed, error: {}", ex.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<AddressRequest> delete(String id) {
        AddressEntity entity = addressRepo.findById(id).orElse(null);
        if (entity == null){
            log.warn("address with id: {}", id);
            return Optional.empty();
        }
        try {
            addressRepo.delete(entity);
            log.info("delete from database successfully");
            return Optional.of(new AddressRequest(entity));
        }catch (Exception ex){
            log.error("delete address from database failed, error: {}", ex.getMessage());
            return Optional.empty();
        }
    }
}
