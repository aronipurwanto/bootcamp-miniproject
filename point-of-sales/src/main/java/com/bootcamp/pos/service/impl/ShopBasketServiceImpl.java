package com.bootcamp.pos.service.impl;

import com.bootcamp.pos.model.entity.RefProductTypeEntity;
import com.bootcamp.pos.model.entity.ShoopingBasketEntity;
import com.bootcamp.pos.model.response.RefProductTypeResponse;
import com.bootcamp.pos.model.response.ShopBasketResponse;
import com.bootcamp.pos.repository.ShopBasketRepo;
import com.bootcamp.pos.service.ShopBasketService;
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
public class ShopBasketServiceImpl implements ShopBasketService {
    private final ShopBasketRepo shopBasketRepo;
    @Override
    public List<ShopBasketResponse> getAll() {
        return shopBasketRepo.findAll().stream().map(ShopBasketResponse::new).collect(Collectors.toList());
    }

    @Override
    public Optional<ShopBasketResponse> getById(String id) {
        ShoopingBasketEntity result = shopBasketRepo.findById(id).orElse(null);
        if(result == null){
            return Optional.empty();
        }
        return Optional.of(new ShopBasketResponse(result));
    }

    @Override
    public Optional<ShopBasketResponse> save(ShopBasketResponse request) {
        if(request == null){
            return Optional.empty();
        }
        ShoopingBasketEntity entity = new ShoopingBasketEntity(request);
        try{
            shopBasketRepo.save(entity);
            log.info("Save ShopBasket to database success");
            return Optional.of(new ShopBasketResponse(entity));
        }catch (Exception e){
            log.error("Save ShopBasket to database failed, error: {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<ShopBasketResponse> update(ShopBasketResponse request, String id) {
        ShoopingBasketEntity entity = shopBasketRepo.findById(id).orElse(null);
        if(entity == null){
            log.warn("ShopBasket dengan Id : {} tidak ada",id);
        }
        BeanUtils.copyProperties(request, entity);
        try{
            shopBasketRepo.save(entity);
            log.info("Update ShopBasket to database success");
            return Optional.of(new ShopBasketResponse(entity));
        }catch (Exception e){
            log.error("Update ShopBasket to database failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<ShopBasketResponse> delete(String id) {
        ShoopingBasketEntity entity = shopBasketRepo.findById(id).orElse(null);
        if(entity == null){
            return Optional.empty();
        }
        try{
            shopBasketRepo.delete(entity);
            log.info("delete ShopBasket from database success");
            return Optional.of(new ShopBasketResponse(entity));
        }catch (Exception e){
            log.error("Delete ShopBasket from database failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }
}
