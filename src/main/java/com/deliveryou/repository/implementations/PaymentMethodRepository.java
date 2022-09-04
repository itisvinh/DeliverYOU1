package com.deliveryou.repository.implementations;

import com.deliveryou.pojo.Category;
import com.deliveryou.pojo.PaymentMethod;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PaymentMethodRepository implements com.deliveryou.repository.interfaces.PaymentMethodRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    public PaymentMethod getPaymentMethod(String name) {
        Session session = sessionFactory.getObject().getCurrentSession();

        return (PaymentMethod) session
                .createQuery("from PaymentMethod where name like :value")
                .setParameter("value", name)
                .getSingleResult();
    }
}
