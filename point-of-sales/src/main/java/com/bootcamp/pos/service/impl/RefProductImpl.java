package com.bootcamp.pos.service.impl;

import com.bootcamp.pos.model.entity.RefProductEntity;
import com.bootcamp.pos.model.request.RefAddressRequest;
import com.bootcamp.pos.model.request.RefProductRequest;
import com.bootcamp.pos.repository.RefAddressRepository;
import com.bootcamp.pos.repository.RefProductRepository;
import com.bootcamp.pos.service.RefAddressService;
import com.bootcamp.pos.service.RefProductService;
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
public class RefProductImpl implements RefProductService {
    private final RefProductRepository refProductRepository;
    @Override
    public List<RefProductRequest> getAll() {
        return refProductRepository.findAll().stream()
                .map(RefProductRequest::new)
                .collect(Collectors.toList());
    }

    @Override
    public RefProductRequest getById(String id) {
        if (id == null){
            return null;
        }
        return refProductRepository.findById(id)
                .map(RefProductRequest::new)
                .orElse(null);
    }

    @Override
    public Optional<RefProductRequest> save(RefProductRequest request) {
        if (request == null){
            return Optional.empty();
        }

        RefProductEntity refProduct = new RefProductEntity(request);
        try {
            refProductRepository.save(refProduct);
            log.info("Save ref product success");
            return Optional.of(new RefProductRequest());
        }catch (Exception e){
            log.error("Save ref product failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<RefProductRequest> update(RefProductRequest request, String id) {
        RefProductEntity entity = refProductRepository.findById(id).orElse(null);
        if (entity == null){
            log.warn("Delete ref product with id not found : {}", id);
            return Optional.empty();
        }

        BeanUtils.copyProperties(request, entity);
        try {
            refProductRepository.save(entity);
            log.info("Update ref product success");
            return Optional.of(new RefProductRequest());
        }catch (Exception e){
            log.error("Update ref product failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<RefProductRequest> delete(String id) {
        RefProductEntity entity = refProductRepository.findById(id).orElse(null);
        if (entity == null){
            return Optional.empty();
        }

        try {
            refProductRepository.delete(entity);
            log.info("Delete ref product success");
            return Optional.of(new RefProductRequest());
        }catch (Exception e){
            log.error("Delete ref product failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }
}
