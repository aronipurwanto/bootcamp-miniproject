package com.bootcamp.pos.service.impl;

import com.bootcamp.pos.model.entity.AddressesEntity;
import com.bootcamp.pos.model.entity.RefPaymentEntity;
import com.bootcamp.pos.model.response.AddressesResponse;
import com.bootcamp.pos.model.response.RefPaymentResponse;
import com.bootcamp.pos.repository.RefPaymentRepo;
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
public class RefPaymentServiceImpl implements RefPaymentService {

    private final RefPaymentRepo refPaymentRepo;
    @Override
    public List<RefPaymentResponse> getAll() {
        return refPaymentRepo.findAll().stream().map(RefPaymentResponse::new).collect(Collectors.toList());
    }

    @Override
    public Optional<RefPaymentResponse> getById(String id) {
        RefPaymentEntity result = this.refPaymentRepo.findById(id).orElse(null);
        if(result == null){
            return Optional.empty();
        }
        return Optional.of(new RefPaymentResponse(result));
    }

    @Override
    public Optional<RefPaymentResponse> save(RefPaymentResponse request) {
        if(request == null){
            return Optional.empty();
        }
        RefPaymentEntity entity = new RefPaymentEntity(request);
        try{
            refPaymentRepo.save(entity);
            log.info("Save Paymnet to database success");
            return Optional.of(new RefPaymentResponse(entity));
        }catch (Exception e){
            log.error("Save Paymnet to database failed, error: {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<RefPaymentResponse> update(RefPaymentResponse request, String id) {
        RefPaymentEntity entity = refPaymentRepo.findById(id).orElse(null);
        if(entity == null){
            log.warn("Payment dengan id: {} tidak ada",id);
            return Optional.empty();
        }
        BeanUtils.copyProperties(request,entity);
        try{
            refPaymentRepo.save(entity);
            log.info("Update Payment to database success");
            return Optional.of(new RefPaymentResponse(entity));
        }catch (Exception e){
            log.error("Update Payment to database failed, error: {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<RefPaymentResponse> delete(String id) {
        RefPaymentEntity entity = refPaymentRepo.findById(id).orElse(null);
        if(entity == null){
            return Optional.empty();
        }
        try{
            refPaymentRepo.delete(entity);
            log.info("Delete Payment from database success");
            return Optional.of(new RefPaymentResponse(entity));
        }catch (Exception e){
            log.error("Delete Payment from database failed, error: {}",e.getMessage());
            return Optional.empty();
        }
    }
}
