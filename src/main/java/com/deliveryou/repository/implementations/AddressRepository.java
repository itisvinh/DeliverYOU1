package com.deliveryou.repository.implementations;

import com.deliveryou.pojo.Address;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AddressRepository implements com.deliveryou.repository.interfaces.AddressRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public int addAddress(Address address) {
        Session session = sessionFactory.getObject().getCurrentSession();
        try {
            session.save(address);
            return address.getId();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    @Override
    public Address getAddress(int id) {
        Session session = sessionFactory.getObject().getCurrentSession();

        return (Address) session
                .createQuery("from Address where id=:value")
                .setParameter("value", id)
                .getSingleResult();
    }
}
