package com.bootcamp.pos.sImpl;

import com.bootcamp.pos.model.entity.SuppliersEntity;
import com.bootcamp.pos.model.request.SuppliersModel;
import com.bootcamp.pos.repository.SuppliersRepository;
import com.bootcamp.pos.service.SuppliersService;
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
public class SuppliersServiceImpl implements SuppliersService {
    private final SuppliersRepository suppliersRepository;

    @Override
    public List<SuppliersModel> getAll() {
        List<SuppliersEntity> result = this.suppliersRepository.findAll();
        if (result == null) {
            return Collections.emptyList();
        }
        return result.stream().map(SuppliersModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SuppliersModel> getById(String id) {
        SuppliersEntity result = this.suppliersRepository.findById(id).orElse(null);
        if (result == null) {
            return Optional.empty();
        }

        return Optional.of(new SuppliersModel(result));
    }

    @Override
    public Optional<SuppliersModel> save(SuppliersModel request) {
        if (request == null) {
            return Optional.empty();
        }

        SuppliersEntity entity = new SuppliersEntity(request);
        try {
            this.suppliersRepository.save(entity);
            log.info("Save data supplier to database success");
            return Optional.of(new SuppliersModel(entity));
        } catch (Exception er) {
            log.warn("Save data supplier failed, error: {}", er.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<SuppliersModel> update(SuppliersModel request, String id) {
        Optional<SuppliersEntity> entity = this.suppliersRepository.findById(id);
        if (entity.isEmpty())
            return Optional.empty();

        SuppliersEntity data = entity.get();
        BeanUtils.copyProperties(request, data);
        try {
            this.suppliersRepository.save(data);
            log.info("Update supplier to database success");
            return Optional.of(new SuppliersModel(data));
        } catch (Exception e) {
            log.error("Update supplier to database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<SuppliersModel> delete(String id) {
        SuppliersEntity result = this.suppliersRepository.findById(id).orElse(null);
        if (result == null) {
            log.warn("data supplier with id: {} not found", id);
            return Optional.empty();
        }
        try {
            this.suppliersRepository.delete(result);
            log.info("Delete data supplier from database success");
            return Optional.of(new SuppliersModel(result));
        } catch (Exception er) {
            log.error("Delete data supplier failed, error: {}", er.getMessage());
            return Optional.empty();
        }
    }
}
