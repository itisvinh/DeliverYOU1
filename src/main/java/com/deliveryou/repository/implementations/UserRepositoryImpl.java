package com.deliveryou.repository.implementations;

import com.deliveryou.pojo.DriverRegistration;
import com.deliveryou.pojo.Role;
import com.deliveryou.pojo.User;
import com.deliveryou.pojo.auxiliary.RegistrationFilter;
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
import java.util.Collections;
import java.util.List;

@Repository
@Transactional
public class UserRepositoryImpl implements com.deliveryou.repository.interfaces.UserRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    @Transactional
    public boolean addUser(User user) {
        Session session = sessionFactory.getObject().getCurrentSession();

        session.save(user);

        return true;
    }

    @Override
    public boolean updateUser(User user) {
        Session session = sessionFactory.getObject().getCurrentSession();

        session.update(user);
        return true;
    }

    @Override
    public boolean deactivateUser(int id) {
        return false;
    }

    @Override
    public User getUser(String phoneNumber) {
        System.out.println("PHONE: " + phoneNumber);
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root root = criteriaQuery.from(User.class);
        criteriaQuery.select(root);

        if (!phoneNumber.isEmpty()) {
            Predicate predicate = criteriaBuilder.equal(root.get("phoneNumber").as(String.class), phoneNumber.trim());
            criteriaQuery = criteriaQuery.where(predicate);
        }

        Object result = null;
        try {
            result = session.createQuery(criteriaQuery).getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result == null ? null : (User) result;
    }

    @Override
    public User getUser(int id) {
        Session session = sessionFactory.getObject().getCurrentSession();

        try {
            return (User) session
                    .createQuery("from User where id=:value")
                    .setParameter("value", id)
                    .getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> getUserList() {
        Session session = sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("FROM User ");
        return query.getResultList();
    }

    @Override
    public int getIdByPhone(String phone) {
        Session session = sessionFactory.getObject().getCurrentSession();

        try {
            Object o = session.createQuery("select id from User where phoneNumber = :p")
                    .setParameter("p", phone)
                    .getSingleResult();
            return (int)o;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<User> getUsersWithinRange(String role_name, int start, int end) {
        Session session = sessionFactory.getObject().getCurrentSession();

        return session.createQuery("from User where role.name=:role")
                .setParameter("role", role_name)
                .setMaxResults(end)
                .setFirstResult(start)
                .getResultList();
    }

    @Override
    public boolean createDriverRegistration(DriverRegistration registration) {
        Session session = sessionFactory.getObject().getCurrentSession();

        try {
            session.merge(registration);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<DriverRegistration> getDriverRegistrations(RegistrationFilter filter) {
        Session session = sessionFactory.getObject().getCurrentSession();
        Query query = null;
        final String pre = "select dr from DriverRegistration dr ";

        switch (filter) {
            case IS_NOT_PROCESSED:
                query = session.createQuery(pre + " where dr.isProcessed=:p").setParameter("p", (byte) 0);
                break;
            case IS_PROCESSED:
                query = session.createQuery(pre + " where dr.isProcessed=:p").setParameter("p", (byte) 1);
                break;
            case ALL:
                query = session.createQuery(pre);
                break;
        }

        if (query != null) {
            List<DriverRegistration> list = query.getResultList();
            System.out.println("Reg list: " + list);
            return list != null && list.size() > 0 ? list : null;
        }
        System.err.println("Failed to create query [getDriverRegistrations(...)]");
        return null;
    }

    @Override
    public boolean processDriverRegistration(DriverRegistration registration) {
        Session session = sessionFactory.getObject().getCurrentSession();

        try {
            session.merge(registration);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public DriverRegistration getDriverRegistration(int id) {
        Session session = sessionFactory.getObject().getCurrentSession();

        try {
            return (DriverRegistration) session.createQuery("from DriverRegistration where id=:id")
                    .setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
