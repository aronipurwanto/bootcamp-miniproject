package com.bootcamp.pos.sImpl;

import com.bootcamp.pos.model.entity.PaymentMethodsEntity;
import com.bootcamp.pos.model.request.PaymentMethodsModel;
import com.bootcamp.pos.repository.PaymentMethodsRepository;
import com.bootcamp.pos.service.PaymentMethodsService;
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
public class PaymentMethodsServiceImpl implements PaymentMethodsService {
    private final PaymentMethodsRepository paymentMethodsRepository;
    @Override
    public List<PaymentMethodsModel> getAll() {
        List<PaymentMethodsEntity> result = this.paymentMethodsRepository.findAll();
        if (result == null){
            return Collections.emptyList();
        }
        return result.stream()
                .map(PaymentMethodsModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PaymentMethodsModel> getById(String id) {
        PaymentMethodsEntity result = this.paymentMethodsRepository.findById(id).orElse(null);
        if (result == null){
            return Optional.empty();
        }
        return Optional.of(new PaymentMethodsModel(result));
    }

    @Override
    public Optional<PaymentMethodsModel> save(PaymentMethodsModel request) {
        if (request == null){
            return Optional.empty();
        }
        PaymentMethodsEntity entity = new PaymentMethodsEntity(request);
        try {
            this.paymentMethodsRepository.save(entity);
            log.info("Save Payment Method to database success");
            return Optional.of(new PaymentMethodsModel(entity));
        }catch (Exception e){
            log.error("save Payment Method to database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<PaymentMethodsModel> update(PaymentMethodsModel request, String id) {
        Optional<PaymentMethodsEntity> entity = this.paymentMethodsRepository.findById(id);
        if (entity.isEmpty())
            return Optional.empty();

        PaymentMethodsEntity data = entity.get();
        BeanUtils.copyProperties(request, data);

        try {
            this.paymentMethodsRepository.save(data);
            log.info("Update Payment Method to database success");
            return Optional.of(new PaymentMethodsModel(data));
        }catch (Exception e){
            log.error("Update Payment Method to database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<PaymentMethodsModel> delete(String id) {
        PaymentMethodsEntity result = this
                .paymentMethodsRepository.findById(id).orElse(null);
        if (result == null){
            log.warn("data payment method with id: {} not found", id);
        }
        try {
            this.paymentMethodsRepository.delete(result);
            log.info("Delete Payment Methods from database success");
            return Optional.of(new PaymentMethodsModel(result));
        }catch (Exception e){
            log.error("Delete Payment Method from database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }
}
