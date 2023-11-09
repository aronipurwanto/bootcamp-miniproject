package com.bootcamp.pos.service.impl;

import com.bootcamp.pos.model.entity.AddressEntity;
import com.bootcamp.pos.model.entity.RefPaymentMethodsEntity;
import com.bootcamp.pos.model.request.AddressRequest;
import com.bootcamp.pos.model.request.RefPaymentMethodsRequest;
import com.bootcamp.pos.repository.RefPaymentMethodsRepo;
import com.bootcamp.pos.service.RefPaymentMethodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RefPaymentMethodsImpl implements RefPaymentMethodsService {
    private final RefPaymentMethodsRepo refPaymentMethodsRepo;

    public RefPaymentMethodsImpl(RefPaymentMethodsRepo refPaymentMethodsRepo) {
        this.refPaymentMethodsRepo = refPaymentMethodsRepo;
    }

    @Override
    public List<RefPaymentMethodsRequest> getAll() {
        return this.refPaymentMethodsRepo.findAll().stream().map(RefPaymentMethodsRequest::new).collect(Collectors.toList());
    }

    @Override
    public RefPaymentMethodsRequest getById(String id) {
        if (id == null){
            new RefPaymentMethodsRequest();
        }
        return this.refPaymentMethodsRepo.findById(id).map(RefPaymentMethodsRequest::new).orElse(new RefPaymentMethodsRequest());
    }

    @Override
    public Optional<RefPaymentMethodsRequest> save(RefPaymentMethodsRequest request) {
        if (request == null){
            return Optional.empty();
        }
        RefPaymentMethodsEntity entity = new RefPaymentMethodsEntity(request);

        try {
            refPaymentMethodsRepo.save(entity);
            log.info("save refPaymentMethods to database successfully");
            return Optional.of(new RefPaymentMethodsRequest(entity));
        }catch (Exception ex){
            log.error("save refPaymentMethods to database failed, error:{}", ex.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<RefPaymentMethodsRequest> update(RefPaymentMethodsRequest request, String id) {
        RefPaymentMethodsEntity entity = refPaymentMethodsRepo.findById(id).orElse(null);
        if (entity == null){
            log.warn("refPaymentMethods with id: {}, not fount", id);
            return Optional.empty();
        }
        BeanUtils.copyProperties(request, entity);

        try {
            refPaymentMethodsRepo.save(entity);
            log.info("update refPaymentMethodsRepo to database successfully");
            return Optional.of(new RefPaymentMethodsRequest(entity));
        }catch (Exception ex){
            log.error("update refPaymentMethodsRepo to database failed, error: {}", ex.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<RefPaymentMethodsRequest> delete(String id) {
        RefPaymentMethodsEntity entity = refPaymentMethodsRepo.findById(id).orElse(null);
        if (entity == null){
            log.warn("refPaymentMethodsRepo with id: {}", id);
            return Optional.empty();
        }
        try {
            refPaymentMethodsRepo.delete(entity);
            log.info("delete from database successfully");
            return Optional.of(new RefPaymentMethodsRequest(entity));
        }catch (Exception ex){
            log.error("delete refPaymentMethodsRepo from database failed, error: {}", ex.getMessage());
            return Optional.empty();
        }
    }
}
