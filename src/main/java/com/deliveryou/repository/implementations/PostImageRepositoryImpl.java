package com.deliveryou.repository.implementations;

import com.deliveryou.pojo.PostImage;
import com.deliveryou.repository.interfaces.PostImageRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

@Repository
public class PostImageRepositoryImpl implements PostImageRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public int addPostImage(PostImage postImage) {
        Session session = sessionFactory.getObject().getCurrentSession();

        try {
            session.save(postImage);
            return postImage.getId();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }
}
