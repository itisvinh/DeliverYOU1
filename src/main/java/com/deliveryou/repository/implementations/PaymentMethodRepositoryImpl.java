package com.deliveryou.repository.implementations;

import com.deliveryou.factory.ConstantPersistenceMap;
import com.deliveryou.pojo.Category;
import com.deliveryou.pojo.PaymentMethod;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentMethodRepositoryImpl implements com.deliveryou.repository.interfaces.PaymentMethodRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    public PaymentMethod getPaymentMethod(String name) {
        Session session = sessionFactory.getObject().getCurrentSession();

        PaymentMethod paymentMethod = (PaymentMethod) session
                .createQuery("from PaymentMethod where name like :value")
                .setParameter("value", name)
                .getSingleResult();
        return (PaymentMethod) ConstantPersistenceMap.access(paymentMethod);
    }
}
