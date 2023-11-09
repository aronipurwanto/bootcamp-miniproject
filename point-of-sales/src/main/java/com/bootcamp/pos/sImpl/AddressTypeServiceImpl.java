package com.bootcamp.pos.sImpl;

import com.bootcamp.pos.model.entity.AddressTypeEntity;
import com.bootcamp.pos.model.request.AddressTypeModel;
import com.bootcamp.pos.repository.AddressTypeRepository;
import com.bootcamp.pos.service.AddressTypeService;
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
public class AddressTypeServiceImpl implements AddressTypeService {
    private final AddressTypeRepository addressTypeRepository;

    @Override
    public List<AddressTypeModel> getAll() {
        List<AddressTypeEntity> entity = this.
        addressTypeRepository.findAll();
        if (entity == null){
            return Collections.emptyList();
        }
        return entity.stream().map(AddressTypeModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AddressTypeModel> getById(String id) {
        AddressTypeEntity entity = this.addressTypeRepository.findById(id).orElse(null);
        if ( entity == null){
            return Optional.empty();
        }

        return Optional.of(new AddressTypeModel(entity));
    }

    @Override
    public Optional<AddressTypeModel> save(AddressTypeModel request) {
        if (request == null){
            return Optional.empty();
        }

        AddressTypeEntity entity = new AddressTypeEntity(request);
        try {
            this.addressTypeRepository.save(entity);
            log.info("Save Address Type to database success");
            return Optional.of(new AddressTypeModel(entity));
        }catch (Exception e){
            log.error("Save Address Type to database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<AddressTypeModel> update(AddressTypeModel request, String id) {
        Optional<AddressTypeEntity> entity = this.addressTypeRepository.findById(id);
        if (entity.isEmpty())
            return Optional.empty();

        AddressTypeEntity data = entity.get();
        BeanUtils.copyProperties(request, data);
        try {
            this.addressTypeRepository.save(data);
            log.info("Update Address Type to database success");
            return Optional.of(new AddressTypeModel(data));
        }catch (Exception e){
            log.error("Update Address Type to database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<AddressTypeModel> delete(String id) {
        AddressTypeEntity result = this.addressTypeRepository.findById(id).orElse(null);
        if (result == null){
            log.warn("address type with id: {} not found", id);
            return Optional.empty();
        }
        try {
            this.addressTypeRepository.delete(result);
            log.info("Delete Address Type from database success");
            return Optional.of(new AddressTypeModel(result));
        }catch (Exception e){
            log.error("Delete Address Type from database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }
}
