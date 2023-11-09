package com.bootcamp.pos.service.impl;

import com.bootcamp.pos.model.entity.CustomerEntity;
import com.bootcamp.pos.model.entity.ShoppingBasketEntity;
import com.bootcamp.pos.model.request.ShoppingBasketRequest;
import com.bootcamp.pos.repository.CustomerRepository;
import com.bootcamp.pos.repository.ShoppingBasketRepository;
import com.bootcamp.pos.service.ShoppingBasketService;
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
public class ShoppingBasketImpl implements ShoppingBasketService {
    private final ShoppingBasketRepository shoppingBasketRepository;
    private final CustomerRepository customerRepository;
    @Override
    public List<ShoppingBasketRequest> getAll() {
        return shoppingBasketRepository.findAll().stream()
                .map(ShoppingBasketRequest::new)
                .collect(Collectors.toList());
    }

    @Override
    public ShoppingBasketRequest getById(String id) {
        if (id == null){
            return null;
        }

        return shoppingBasketRepository.findById(id)
                .map(ShoppingBasketRequest::new)
                .orElse(null);
    }

    @Override
    public Optional<ShoppingBasketRequest> save(ShoppingBasketRequest request) {
        if (request == null){
            return Optional.empty();
        }

        CustomerEntity customer = customerRepository.findById(request.getCustomerId()).orElse(null);
        if (customer == null){
            return Optional.empty();
        }

        ShoppingBasketEntity entity = new ShoppingBasketEntity(request, customer);
        try {
            shoppingBasketRepository.save(entity);
            log.info("Save shopping basket success");
            return Optional.of(new ShoppingBasketRequest());
        }catch (Exception e){
            log.error("Save shopping basket failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<ShoppingBasketRequest> update(ShoppingBasketRequest request, String id) {
        ShoppingBasketEntity entity = shoppingBasketRepository.findById(id).orElse(null);
        if (entity == null){
            return Optional.empty();
        }

        BeanUtils.copyProperties(request, entity);
        try {
            shoppingBasketRepository.save(entity);
            log.info("Update shopping basket success");
            return Optional.of(new ShoppingBasketRequest());
        }catch (Exception e){
            log.error("Update shopping basket failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<ShoppingBasketRequest> delete(String id) {
        ShoppingBasketEntity entity = shoppingBasketRepository.findById(id).orElse(null);
        if (entity == null){
            return Optional.empty();
        }

        try {
            shoppingBasketRepository.delete(entity);
            log.info("Delete shopping basket success");
            return Optional.of(new ShoppingBasketRequest());
        }catch (Exception e){
            log.error("Delete shopping basket failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }
}
