package com.deliveryou.service.interfaces;

import com.deliveryou.pojo.Status;

import java.util.List;

public interface StatusService {
    Status getStatus(String name);
    List<Status> getAllStatus();

}
