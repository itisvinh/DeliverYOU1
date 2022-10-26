package com.deliveryou.repository.implementations;

import com.deliveryou.pojo.Role;
import com.deliveryou.repository.interfaces.RoleRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    @Transactional
    public Role getRole(int roleId) {
        Session session = sessionFactory.getObject().getCurrentSession();
        return (Role) session.createQuery("FROM Role WHERE id = :value")
                .setParameter("value", roleId)
                .getSingleResult();

    }
}
