package com.bootcamp.pos.service.impl;

import com.bootcamp.pos.model.entity.AddressesEntity;
import com.bootcamp.pos.model.response.AddressesResponse;
import com.bootcamp.pos.repository.AddressesRepo;
import com.bootcamp.pos.service.AddressesService;
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
public class AddressesServiceImpl implements AddressesService {
    private final AddressesRepo addressesRepo;
    @Override
    public List<AddressesResponse> getAll() {
        return addressesRepo.findAll().stream().map(AddressesResponse::new).collect(Collectors.toList());
    }

    @Override
    public Optional<AddressesResponse> getById(String id) {
        AddressesEntity result = this.addressesRepo.findById(id).orElse(null);
        if(result == null){
            return Optional.empty();
        }
        return Optional.of(new AddressesResponse(result));
    }

    @Override
    public Optional<AddressesResponse> save(AddressesResponse request) {
        if(request == null){
            return Optional.empty();
        }
        AddressesEntity entity = new AddressesEntity(request);
        try{
            addressesRepo.save(entity);
            log.info("Save Address to database success");
            return Optional.of(new AddressesResponse(entity));
        }catch (Exception e){
            log.error("Save Address to database failed, error: {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<AddressesResponse> update(AddressesResponse request, String id) {
        AddressesEntity entity = addressesRepo.findById(id).orElse(null);
        if(entity == null){
            log.warn("Address dengan id: {} tidak ada",id);
            return Optional.empty();
        }
        BeanUtils.copyProperties(request, entity);
        try{
            addressesRepo.save(entity);
            log.info("Update Address to database success");
            return Optional.of(new AddressesResponse(entity));
        }catch (Exception e){
            log.error("Update Address to database failed, error: {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<AddressesResponse> delete(String id) {
        AddressesEntity entity = addressesRepo.findById(id).orElse(null);
            if(entity == null){
                return Optional.empty();
            }
            try{
                addressesRepo.delete(entity);
                log.info("Delete Address from database success");
                return Optional.of(new AddressesResponse(entity));
            }catch (Exception e){
                log.error("Delete Address from database failed, error: {}",e.getMessage());
                return Optional.empty();
            }
    }
}
