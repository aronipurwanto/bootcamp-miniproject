package com.bootcamp.pos.service.impl;

import com.bootcamp.pos.model.entity.RefAddressEntity;
import com.bootcamp.pos.model.request.RefAddressRequest;
import com.bootcamp.pos.repository.RefAddressRepository;
import com.bootcamp.pos.service.RefAddressService;
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
public class RefAddressImpl implements RefAddressService {
    private final RefAddressRepository refAddressRepository;
    @Override
    public List<RefAddressRequest> getAll() {
        return refAddressRepository.findAll().stream().map(RefAddressRequest::new).collect(Collectors.toList());
    }

    @Override
    public RefAddressRequest getById(String id) {
        if (id == null){
            return null;
        }
        return refAddressRepository.findById(id).map(RefAddressRequest::new).orElse(null);
    }

    @Override
    public Optional<RefAddressRequest> save(RefAddressRequest request) {
        if (request == null){
            return Optional.empty();
        }

        RefAddressEntity entity = new RefAddressEntity(request);
        try {
            refAddressRepository.save(entity);
            log.info("Save ref address Success");
            return Optional.of(new RefAddressRequest());
        }catch (Exception e){
            log.error("Save ref address failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<RefAddressRequest> update(RefAddressRequest request, String id) {
        RefAddressEntity entity = refAddressRepository.findById(id).orElse(null);
        if (entity == null){
            return Optional.empty();
        }

        BeanUtils.copyProperties(request, entity);
        try {
            refAddressRepository.save(entity);
            log.info("Update ref address success");
            return Optional.of(new RefAddressRequest());
        }catch (Exception e){
            log.error("Update ref address failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<RefAddressRequest> delete(String id) {
        RefAddressEntity entity = refAddressRepository.findById(id).orElse(null);
        if (entity == null){
            return Optional.empty();
        }

        try {
            refAddressRepository.delete(entity);
            log.info("Delete ref address success");
            return Optional.of(new RefAddressRequest());
        }catch (Exception e){
            log.error("Delete ref address failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }
}
