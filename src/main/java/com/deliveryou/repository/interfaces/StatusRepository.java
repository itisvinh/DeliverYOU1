package com.deliveryou.repository.interfaces;

import com.deliveryou.pojo.Status;

import java.util.List;

public interface StatusRepository {
    Status getStatus(String name);

    List<Status> getAllStatus();
}
