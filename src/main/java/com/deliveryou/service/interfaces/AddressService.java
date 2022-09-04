package com.deliveryou.service.interfaces;

import com.deliveryou.pojo.Address;

public interface AddressService {
    Address getAddress(int id);
    int addAddress(Address address);
}
