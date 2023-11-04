package com.bootcamp.pos.sImpl;

import com.bootcamp.pos.model.entity.AddressEntity;
import com.bootcamp.pos.model.request.AddressModel;
import com.bootcamp.pos.repository.AddressRepository;
import com.bootcamp.pos.service.AddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    @Override
    public List<AddressModel> getAll() {
        List<AddressEntity> entity = this.addressRepository.findAll();
        if ( entity == null){
            return Collections.emptyList();
        }
        return entity.stream().map(AddressModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AddressModel> getById(String id) {
        AddressEntity entity = this.addressRepository.findById(id).orElse(null);
        if ( entity == null){
            return Optional.empty();
        }

        return Optional.of(new AddressModel(entity));
    }

    @Override
    public Optional<AddressModel> save(AddressModel request) {
        if (request == null){
            return Optional.empty();
        }

        AddressEntity entity = new AddressEntity(request);
        try {
            this.addressRepository.save(entity);
            log.info("Save Address to database success");
            return Optional.of(new AddressModel(entity));
        }catch (Exception e){
            log.error("Save Address to database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<AddressModel> update(AddressModel request, String id) {
        Optional<AddressEntity> entity = this.addressRepository.findById(id);
        if (entity.isEmpty())
            return Optional.empty();

        AddressEntity data = entity.get();
        BeanUtils.copyProperties(request, data);
        try {
            this.addressRepository.save(data);
            log.info("Update Address to database success");
            return Optional.of(new AddressModel(data));
        }catch (Exception e){
            log.error("Update address to database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<AddressModel> delete(String id) {
        AddressEntity result = this.addressRepository.findById(id).orElse(null);
        if (result == null){
            log.warn("address with id: {} not found", id);
            return Optional.empty();
        }
        try {
            this.addressRepository.delete(result);
            log.info("Delete address from database success");
            return Optional.of(new AddressModel(result));
        }catch (Exception e){
            log.error("Delete address from database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }
}
