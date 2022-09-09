package com.deliveryou.repository.implementations;

import com.deliveryou.factory.ConstantPersistenceMap;
import com.deliveryou.pojo.Category;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

@Repository
public class CategoryRepositoryImpl implements com.deliveryou.repository.interfaces.CategoryRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public Category getCategory(int id) {
        Session session = sessionFactory.getObject().getCurrentSession();

        return (Category) session
                .createQuery("from Category where id=:value")
                .setParameter("value", id)
                .getSingleResult();
    }

    @Override
    public Category getCategory(String name) {
        Session session = sessionFactory.getObject().getCurrentSession();

        Category category = null;
        try {
            category = (Category) session
                    .createQuery("from Category where name like :value")
                    .setParameter("value", name)
                    .getSingleResult();
        } catch (NoResultException ex) {

        }
        if (category != null) {
            Category res = (Category) ConstantPersistenceMap.access(category);
            return res;
        }
        return null;

    }
}
