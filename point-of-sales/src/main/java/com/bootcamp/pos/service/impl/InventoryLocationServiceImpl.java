package com.bootcamp.pos.service.impl;

import com.bootcamp.pos.model.entity.InventoryLocationEntity;
import com.bootcamp.pos.model.response.InventoryLocationResponse;
import com.bootcamp.pos.repository.InventoryLocationRepo;
import com.bootcamp.pos.service.InventoryLocationService;
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
public class InventoryLocationServiceImpl implements InventoryLocationService {
    private final InventoryLocationRepo inventoryLocationRepo;
    @Override
    public List<InventoryLocationResponse> getAll() {
        return inventoryLocationRepo.findAll().stream().map(InventoryLocationResponse::new).collect(Collectors.toList());
    }

    @Override
    public Optional<InventoryLocationResponse> getById(String id) {
        InventoryLocationEntity result = inventoryLocationRepo.findById(id).orElse(null);
        if(result == null){
            return Optional.empty();
        }
        return Optional.of(new InventoryLocationResponse(result));
    }

    @Override
    public Optional<InventoryLocationResponse> save(InventoryLocationResponse request) {
       if(request == null){
           return Optional.empty();
       }
       InventoryLocationEntity entity = new InventoryLocationEntity(request);
       try{
           inventoryLocationRepo.save(entity);
           log.info("Save InLocation to database success");
           return Optional.of(new InventoryLocationResponse(entity));
       }catch (Exception e){
           log.error("Save InLocation to database failed, error : {}",e.getMessage());
           return Optional.empty();
       }
    }

    @Override
    public Optional<InventoryLocationResponse> update(InventoryLocationResponse request, String id) {
        InventoryLocationEntity entity = inventoryLocationRepo.findById(id).orElse(null);
            if(entity == null){
                log.warn("InLocation dengan id : {} tidak ada",id);
                return Optional.empty();
            }
            BeanUtils.copyProperties(request, entity);
            try{
                inventoryLocationRepo.save(entity);
                log.info("Update InLocation to database success");
                return Optional.empty();
            }catch (Exception e){
                log.error("Update InLocation to database failed, error: {}",e.getMessage());
                return Optional.empty();
            }
    }

    @Override
    public Optional<InventoryLocationResponse> delete(String id) {
        InventoryLocationEntity entity = inventoryLocationRepo.findById(id).orElse(null);
        if(entity == null){
            return Optional.empty();
        }
        try{
            inventoryLocationRepo.delete(entity);
            log.info("Delete InLocal from database success");
            return Optional.of(new InventoryLocationResponse(entity));
        }catch (Exception e){
            log.error("Delete InLocal from database failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }
}
