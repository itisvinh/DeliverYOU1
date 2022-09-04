package com.deliveryou.repository.interfaces;

import com.deliveryou.pojo.Address;

public interface AddressRepository {
    /**
     * @param address
     * @return id of the added address
     */
    int addAddress(Address address);

    Address getAddress(int id);
}
