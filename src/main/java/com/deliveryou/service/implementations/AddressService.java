package com.deliveryou.service.implementations;

import com.deliveryou.pojo.Address;
import com.deliveryou.repository.implementations.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AddressService implements com.deliveryou.service.interfaces.AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address getAddress(int id) {
        return addressRepository.getAddress(id);
    }

    @Override
    public int addAddress(Address address) {
        return addressRepository.addAddress(address);
    }
}
