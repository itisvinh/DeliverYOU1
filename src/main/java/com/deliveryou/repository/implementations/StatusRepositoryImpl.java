package com.deliveryou.repository.implementations;

import com.deliveryou.factory.ConstantPersistenceMap;
import com.deliveryou.pojo.Category;
import com.deliveryou.pojo.Status;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StatusRepositoryImpl implements com.deliveryou.repository.interfaces.StatusRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    public Status getStatus(String name) {
        Session session = sessionFactory.getObject().getCurrentSession();

        Status status = (Status) session
                .createQuery("from Status where name like :value")
                .setParameter("value", name)
                .getSingleResult();

        return (Status) ConstantPersistenceMap.access(status);
    }

    @Override
    public List<Status> getAllStatus() {
        Session session = sessionFactory.getObject().getCurrentSession();

        List<Status> list = session.createQuery("from Status").getResultList();
        return list;
    }
}
