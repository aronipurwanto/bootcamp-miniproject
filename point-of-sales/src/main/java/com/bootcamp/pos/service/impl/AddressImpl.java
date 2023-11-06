package com.bootcamp.pos.service.impl;

import com.bootcamp.pos.model.entity.AddressEntity;
import com.bootcamp.pos.model.request.AddressRequest;
import com.bootcamp.pos.model.request.CustomerRequest;
import com.bootcamp.pos.repository.AddressRepository;
import com.bootcamp.pos.service.AddressService;
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
public class AddressImpl implements AddressService {
    private final AddressRepository addressRepository;
    @Override
    public List<AddressRequest> getAll() {
        return addressRepository.findAll().stream().map(AddressRequest::new).collect(Collectors.toList());
    }

    @Override
    public AddressRequest getById(String id) {
        if (id == null){
            return null;
        }
        return addressRepository.findById(id).map(AddressRequest::new).orElse(null);
    }

    @Override
    public Optional<AddressRequest> save(AddressRequest request) {
        if (request == null){
            return Optional.empty();
        }
        AddressEntity entity = new AddressEntity(request);
        try {
            addressRepository.save(entity);
            log.info("Save address success");
            return Optional.of(new AddressRequest());
        }catch (Exception e){
            log.error("Save address failed, error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<AddressRequest> update(AddressRequest request, String id) {
        AddressEntity entity = addressRepository.findById(id).orElse(null);
        if (entity == null){
            return Optional.empty();
        }
        BeanUtils.copyProperties(request, entity);
        try {
            addressRepository.save(entity);
            log.info("Update address success");
            return Optional.of(new AddressRequest());
        }catch (Exception e){
            log.error("Update address failed, error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<AddressRequest> delete(String id) {
        AddressEntity entity = addressRepository.findById(id).orElse(null);
        if (entity == null){
            return Optional.empty();
        }
        try {
            addressRepository.delete(entity);
            log.info("Delete address success");
            return Optional.of(new AddressRequest());
        }catch (Exception e){
            log.error("Delete address failed, error : {}", e.getMessage());
            return Optional.empty();
        }
    }
}
