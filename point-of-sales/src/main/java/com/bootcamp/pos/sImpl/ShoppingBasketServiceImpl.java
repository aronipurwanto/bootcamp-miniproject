package com.bootcamp.pos.sImpl;

import com.bootcamp.pos.model.entity.ShoppingBasketEntity;
import com.bootcamp.pos.model.request.ShoppingBasketModel;
import com.bootcamp.pos.repository.ShoppingBasketRepository;
import com.bootcamp.pos.service.ShoppingBasketService;
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
public class ShoppingBasketServiceImpl implements ShoppingBasketService {
    private final ShoppingBasketRepository shoppingBasketRepository;
    @Override
    public List<ShoppingBasketModel> getAll() {
        List<ShoppingBasketEntity> result = this.shoppingBasketRepository.findAll();
        if (result == null){
            return Collections.emptyList();
        }

        return result.stream()
                .map(ShoppingBasketModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ShoppingBasketModel> getById(String id) {
        ShoppingBasketEntity result = this.shoppingBasketRepository.findById(id).orElse(null);
        if (result == null){
            return Optional.empty();
        }
        return Optional.of(new ShoppingBasketModel(result));
    }

    @Override
    public Optional<ShoppingBasketModel> save(ShoppingBasketModel request) {
        if (request == null){
            return Optional.empty();
        }

        ShoppingBasketEntity result = new ShoppingBasketEntity(request);
        try {
            this.shoppingBasketRepository.save(result);
            log.info("Save shopping Basket to database success");
            return Optional.of(new ShoppingBasketModel(result));
        }catch (Exception e){
            log.error("SAve shopping basket to database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<ShoppingBasketModel> update(ShoppingBasketModel request, String id) {
        Optional<ShoppingBasketEntity> result = this.shoppingBasketRepository.findById(id);
        if (result.isEmpty())
            return Optional.empty();

        ShoppingBasketEntity data = result.get();
        BeanUtils.copyProperties(request, data);
        try {
            this.shoppingBasketRepository.save(data);
            log.info("Update shopping basket from database success");
            return Optional.of(new ShoppingBasketModel(data));
        }catch (Exception e){
            log.error("Update shopping basket from database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<ShoppingBasketModel> delete(String id) {
        ShoppingBasketEntity result = this.shoppingBasketRepository.findById(id).orElse(null);
        if (result == null){
            log.warn("data shopping basket with id: {} not found", id);
            return Optional.empty();
        }
        try {
            this.shoppingBasketRepository.delete(result);
            log.info("Delete shopping basket from database success");
            return Optional.of(new ShoppingBasketModel(result));
        }catch (Exception e){
            log.error("Delete shopping basket from database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }
}
