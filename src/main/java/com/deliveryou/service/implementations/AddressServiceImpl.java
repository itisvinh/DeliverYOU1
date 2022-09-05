package com.deliveryou.service.implementations;

import com.deliveryou.pojo.Address;
import com.deliveryou.repository.interfaces.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AddressServiceImpl implements com.deliveryou.service.interfaces.AddressService {
    @Autowired
    private AddressRepository addressRepositoryImpl;

    @Override
    public Address getAddress(int id) {
        return addressRepositoryImpl.getAddress(id);
    }

    @Override
    public int addAddress(Address address) {
        return addressRepositoryImpl.addAddress(address);
    }
}
