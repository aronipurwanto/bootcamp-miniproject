package com.bootcamp.pos.service.impl;

import com.bootcamp.pos.model.entity.BasketItemsEntity;
import com.bootcamp.pos.model.response.BasketItemsResponse;
import com.bootcamp.pos.repository.BasketItemRepo;
import com.bootcamp.pos.service.BasketItemService;
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
public class BasketItemServiceImpl implements BasketItemService {
    private final BasketItemRepo basketItemRepo;
    @Override
    public List<BasketItemsResponse> getAll() {
        return basketItemRepo.findAll().stream().map(BasketItemsResponse::new).collect(Collectors.toList());
    }

    @Override
    public Optional<BasketItemsResponse> getById(String id) {
        BasketItemsEntity result = basketItemRepo.findById(id).orElse(null);
        if(result == null){
            return Optional.empty();
        }
        return Optional.of(new BasketItemsResponse(result));
    }

    @Override
    public Optional<BasketItemsResponse> save(BasketItemsResponse request) {
        if(request == null){
            return Optional.empty();
        }
        BasketItemsEntity entity = new BasketItemsEntity(request);
        try{
            basketItemRepo.save(entity);
            log.info("Save BasketItem to database success");
            return Optional.of(new BasketItemsResponse(entity));
        }catch (Exception e){
            log.error("Save BasketItem to database failed, error: {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<BasketItemsResponse> update(BasketItemsResponse request, String id) {
        BasketItemsEntity entity = basketItemRepo.findById(id).orElse(null);
        if(entity == null){
            log.warn("BasketItem dengan id : {} tidak ada",id);
            return Optional.empty();
        }
        BeanUtils.copyProperties(request, entity);
        try{
            basketItemRepo.save(entity);
            log.info("Update BasketItem to database success");
            return Optional.of(new BasketItemsResponse(entity));
        }catch (Exception e){
            log.error("Update BasketItem to database failed, error: {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<BasketItemsResponse> delete(String id) {
        BasketItemsEntity entity = basketItemRepo.findById(id).orElse(null);
        if(entity == null){
            return Optional.empty();
        }
        try{
            basketItemRepo.delete(entity);
            log.info("Delete BasketItem from database success");
            return Optional.of(new BasketItemsResponse(entity));
        }catch (Exception e){
            log.error("Delete BasketItem from database failed, error: {}",e.getMessage() );
            return Optional.empty();
        }
    }
}
