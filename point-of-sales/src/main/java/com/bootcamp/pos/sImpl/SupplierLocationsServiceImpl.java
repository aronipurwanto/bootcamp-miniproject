package com.bootcamp.pos.sImpl;

import com.bootcamp.pos.model.entity.SupplierLocationsEntity;
import com.bootcamp.pos.model.request.SupplierLocationsModel;
import com.bootcamp.pos.repository.SupplierLocationsRepository;
import com.bootcamp.pos.service.SupplierLocationsService;
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
public class SupplierLocationsServiceImpl implements SupplierLocationsService {
    private final SupplierLocationsRepository supplierLocationsRepository;
    @Override
    public List<SupplierLocationsModel> getAll() {
        List<SupplierLocationsEntity> result = this.supplierLocationsRepository.findAll();
        if (result == null){
            return Collections.emptyList();
        }
        return result.stream()
                .map(SupplierLocationsModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SupplierLocationsModel> getById(String id) {
        SupplierLocationsEntity result = this.supplierLocationsRepository.findById(id).orElse(null);
        if (result == null){
            return Optional.empty();
        }
        return Optional.of(new SupplierLocationsModel(result));
    }

    @Override
    public Optional<SupplierLocationsModel> save(SupplierLocationsModel request) {
        if (request == null){
            return Optional.empty();
        }

        SupplierLocationsEntity entity = new SupplierLocationsEntity(request);
        try {
            this.supplierLocationsRepository.save(entity);
            log.info("Save Supplier Location to database success");
            return Optional.of(new SupplierLocationsModel(entity));
        }catch (Exception e){
            log.error("Save Supplier Location to databse failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<SupplierLocationsModel> update(SupplierLocationsModel request, String id) {
        Optional<SupplierLocationsEntity> entity = this.supplierLocationsRepository.findById(id);
        if (entity.isEmpty())
            return Optional.empty();

        SupplierLocationsEntity data = entity.get();
        BeanUtils.copyProperties(request, data);
        try {
            this.supplierLocationsRepository.save(data);
            log.info("Update Supplier Loc to database success");
            return Optional.of(new SupplierLocationsModel(data));
        }catch (Exception e){
            log.error("Update Supplier Loc to database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<SupplierLocationsModel> delete(String id) {
        SupplierLocationsEntity result = this.supplierLocationsRepository.findById(id).orElse(null);
        if (result == null){
            log.warn("data supplier loc with id: {} not found", id);
            return Optional.empty();
        }
        try {
            this.supplierLocationsRepository.delete(result);
            log.info("Delete supplier loc from database success");
            return Optional.of(new SupplierLocationsModel(result));
        }catch (Exception e){
            log.error("Delete supplier loc from database failed, error: {}", e.getMessage());
            return Optional.empty();
        }

    }
}
