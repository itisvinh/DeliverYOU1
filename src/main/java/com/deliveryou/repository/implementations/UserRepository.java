package com.deliveryou.repository.implementations;

import com.deliveryou.pojo.Category;
import com.deliveryou.pojo.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserRepository implements com.deliveryou.repository.interfaces.UserRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public boolean deactivateUser(int id) {
        return false;
    }

    @Override
    public User getUser(String phoneNumber) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root root = criteriaQuery.from(User.class);
        criteriaQuery.select(root);

        if (!phoneNumber.isEmpty()) {
            Predicate predicate = criteriaBuilder.equal(root.get("phoneNumber").as(String.class), phoneNumber.trim());
            criteriaQuery = criteriaQuery.where(predicate);
        }

        return session.createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    public User getUser(int id) {
        Session session = sessionFactory.getObject().getCurrentSession();

        return (User) session
                .createQuery("from User where id=:value")
                .setParameter("value", id)
                .getSingleResult();
    }

    @Override
    public List<User> getUserList() {
        Session session = sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("FROM User ");
        return query.getResultList();
    }
}
