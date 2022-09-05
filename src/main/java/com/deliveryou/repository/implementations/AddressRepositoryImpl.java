package com.deliveryou.repository.implementations;

import com.deliveryou.pojo.Address;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Transient;

@Repository
public class AddressRepositoryImpl implements com.deliveryou.repository.interfaces.AddressRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;


    // --------------
    @Transient
    public static final String OTHER = "Other";
    @Transient
    public static final String FOOD = "Food";
    @Transient
    public static final String CLOTHES = "Clothes";
    @Transient
    public static final String ELECTRONICS = "Electronics";
    @Transient
    public static final String FRAGILE = "Fragile";

    @Transient
    public static final String CASH_ON_DELIVERY = "COD";
    @Transient
    public static final String MOMO = "Momo";

    @Transient
    public static final String USER = "ROLE_USER";
    @Transient
    public static final String ADMIN = "ROLE_ADMIN";
    @Transient
    public static final String SHIPPER = "ROLE_SHIPPER";

    @Transient
    public static final String ONGOING = "ONGOING";
    @Transient
    public static final String PENDING = "PENDING";
    @Transient
    public static final String DELIVERED = "DELIVERED";
    @Transient
    public static final String CANCELED = "CANCELED";


    //-------------

    @Override
    public int addAddress(Address address) {
        Session session = sessionFactory.getObject().getCurrentSession();
        try {
            session.persist(address);
            return address.getId();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    @Override
    public Address getAddress(int id) {
        Session session = sessionFactory.getObject().getCurrentSession();

        try {
            return (Address) session
                    .createQuery("from Address where id=:value")
                    .setParameter("value", id)
                    .getSingleResult();
        } catch (NoResultException ex) {
        }
        return null;
    }
}
