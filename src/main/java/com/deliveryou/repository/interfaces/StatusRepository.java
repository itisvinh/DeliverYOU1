package com.deliveryou.repository.interfaces;

import com.deliveryou.pojo.Status;

public interface StatusRepository {
    Status getStatus(String name);
}
