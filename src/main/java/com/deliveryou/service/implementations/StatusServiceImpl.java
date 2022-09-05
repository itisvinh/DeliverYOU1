package com.deliveryou.service.implementations;

import com.deliveryou.pojo.Status;
import com.deliveryou.repository.interfaces.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StatusServiceImpl implements com.deliveryou.service.interfaces.StatusService {
    @Autowired
    private StatusRepository statusRepository;

    public Status getStatus(String name) {
        name = name.trim();
        return statusRepository.getStatus(name);
    }
}
