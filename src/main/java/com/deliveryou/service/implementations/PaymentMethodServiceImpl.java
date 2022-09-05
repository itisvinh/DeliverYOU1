package com.deliveryou.service.implementations;

import com.deliveryou.pojo.PaymentMethod;
import com.deliveryou.repository.interfaces.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PaymentMethodServiceImpl implements com.deliveryou.service.interfaces.PaymentMethodService {
    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Override
    public PaymentMethod getPaymentMethod(String name) {
        name = name.trim();
        return paymentMethodRepository.getPaymentMethod(name);
    }
}
