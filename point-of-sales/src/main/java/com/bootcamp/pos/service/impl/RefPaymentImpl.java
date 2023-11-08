package com.bootcamp.pos.service.impl;

import com.bootcamp.pos.model.entity.RefPaymentEntity;
import com.bootcamp.pos.model.request.RefPaymentRequest;
import com.bootcamp.pos.repository.RefPaymentRepository;
import com.bootcamp.pos.service.RefPaymentService;
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
public class RefPaymentImpl implements RefPaymentService {
    private final RefPaymentRepository refPaymentRepository;
    @Override
    public List<RefPaymentRequest> getAll() {
        return refPaymentRepository.findAll().stream().map(RefPaymentRequest::new).collect(Collectors.toList());
    }

    @Override
    public RefPaymentRequest getById(String id) {
        if (id == null){
            return null;
        }
        return refPaymentRepository.findById(id).map(RefPaymentRequest::new).orElse(null);
    }

    @Override
    public Optional<RefPaymentRequest> save(RefPaymentRequest request) {
        if (request == null){
            return Optional.empty();
        }

        RefPaymentEntity entity = new RefPaymentEntity(request);
        try {
            refPaymentRepository.save(entity);
            log.info("Save Ref payment success");
            return Optional.of(new RefPaymentRequest());
        }catch (Exception e){
            log.error("Save ref payment failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<RefPaymentRequest> update(RefPaymentRequest request, String id) {
        RefPaymentEntity entity = refPaymentRepository.findById(id).orElse(null);
        if (entity == null){
            return Optional.empty();
        }

        BeanUtils.copyProperties(request, entity);
        try {
            refPaymentRepository.save(entity);
            log.info("Update ref payment success");
            return Optional.of(new RefPaymentRequest());
        }catch (Exception e){
            log.error("Update ref payment failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<RefPaymentRequest> delete(String id) {
        RefPaymentEntity entity = refPaymentRepository.findById(id).orElse(null);
        if (entity == null){
            return Optional.empty();
        }

        try {
            refPaymentRepository.delete(entity);
            log.info("Delete ref payment success");
            return Optional.of(new RefPaymentRequest());
        }catch (Exception e){
            log.error("Detele ref payment failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }
}
