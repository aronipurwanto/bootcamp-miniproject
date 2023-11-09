package com.bootcamp.pos.service.impl;

import com.bootcamp.pos.model.entity.BasketItemEntity;
import com.bootcamp.pos.model.request.BasketItemRequest;
import com.bootcamp.pos.repository.BasketItemRepository;
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
public class BasketItemImpl implements BasketItemService {
    private final BasketItemRepository basketItemRepository;
    @Override
    public List<BasketItemRequest> getAll() {
        return basketItemRepository.findAll().stream()
                .map(BasketItemRequest::new)
                .collect(Collectors.toList());
    }

    @Override
    public BasketItemRequest getById(String id) {
        if (id == null){
            return null;
        }
        return basketItemRepository.findById(id)
                .map(BasketItemRequest::new)
                .orElse(null);
    }

    @Override
    public Optional<BasketItemRequest> save(BasketItemRequest request) {
        if (request == null){
            return Optional.empty();
        }

        BasketItemEntity entity = new BasketItemEntity(request);
        try {
            basketItemRepository.save(entity);
            log.info("Save basket item success");
            return Optional.of(new BasketItemRequest());
        }catch (Exception e){
            log.error("Save basket item failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<BasketItemRequest> update(BasketItemRequest request, String id) {
        BasketItemEntity entity = basketItemRepository.findById(id).orElse(null);
        if (entity == null){
            return Optional.empty();
        }

        BeanUtils.copyProperties(request, entity);
        try {
            basketItemRepository.save(entity);
            log.info("Update basket item success");
            return Optional.of(new BasketItemRequest());
        }catch (Exception e){
            log.error("Update basket item failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<BasketItemRequest> delete(String id) {
        BasketItemEntity entity = basketItemRepository.findById(id).orElse(null);
        if (entity == null){
            return Optional.empty();
        }

        try {
            basketItemRepository.delete(entity);
            log.info("Delete basket item success");
            return Optional.of(new BasketItemRequest());
        }catch (Exception e){
            log.error("Delete basket item failed, error : {}",e.getMessage());
            return Optional.empty();
        }

    }
}
