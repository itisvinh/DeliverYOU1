package com.deliveryou.repository.interfaces;

import com.deliveryou.pojo.PaymentMethod;

public interface PaymentMethodRepository {
    PaymentMethod getPaymentMethod(String name);
}
