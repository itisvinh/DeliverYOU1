package com.deliveryou.repository.implementations;

import com.deliveryou.pojo.PaymentMethod;
import com.deliveryou.pojo.Status;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StatusRepository implements com.deliveryou.repository.interfaces.StatusRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    public Status getStatus(String name) {
        Session session = sessionFactory.getObject().getCurrentSession();

        return (Status) session
                .createQuery("from Status where name like :value")
                .setParameter("value", name)
                .getSingleResult();
    }
}
