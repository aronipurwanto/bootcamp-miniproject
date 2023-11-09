package com.bootcamp.pos.sImpl;

import com.bootcamp.pos.model.entity.BasketItemEntity;
import com.bootcamp.pos.model.request.BasketItemModel;
import com.bootcamp.pos.repository.BasketItemRepository;
import com.bootcamp.pos.service.BasketItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BasketItemServiceImpl implements BasketItemService {
    private final BasketItemRepository basketItemRepository;
    @Override
    public List<BasketItemModel> getAll() {
        List<BasketItemEntity> entity = this.basketItemRepository.findAll();
        if (entity.isEmpty()){
            return Collections.emptyList();
        }
        return entity.stream()
                .map(BasketItemModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BasketItemModel> getById(String id) {
        BasketItemEntity entity = this.basketItemRepository.findById(id).orElse(null);
        if (entity == null){
            return Optional.empty();
        }
        return Optional.of(new BasketItemModel(entity));
    }

    @Override
    public Optional<BasketItemModel> save(BasketItemModel request) {
        if (request == null){
            return Optional.empty();
        }
        BasketItemEntity entity = new BasketItemEntity(request);
        try {
            this.basketItemRepository.save(entity);
            log.info("Save Basket Item to database success");
            return Optional.of(new BasketItemModel(entity));
        }catch (Exception e){
            log.error("Save basket item to database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<BasketItemModel> update(BasketItemModel request, String id) {
        Optional<BasketItemEntity> entity = this.basketItemRepository.findById(id);
        if (entity.isEmpty())
            return Optional.empty();

        BasketItemEntity data = entity.get();
        BeanUtils.copyProperties(request, data);
        try {
            this.basketItemRepository.save(data);
            log.info("Update basket item from database success");
            return Optional.of(new BasketItemModel(data));
        }catch (Exception e){
            log.error("Update basket item from database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<BasketItemModel> delete(String id) {
        BasketItemEntity entity = this.basketItemRepository.findById(id).orElse(null);
        if (entity == null){
            log.warn("basket item with id: {} not found", id);
            return Optional.empty();
        }
        try {
            this.basketItemRepository.delete(entity);
            log.info("Delete basket item from database succes");
            return Optional.of(new BasketItemModel(entity));
        }catch (Exception e){
            log.error("Delete basket item from database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }
}
