package com.deliveryou.repository.implementations;

import com.deliveryou.pojo.PostAuction;
import com.deliveryou.pojo.PostAuctionKey;
import com.deliveryou.repository.interfaces.PostAuctionsRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public class PostAuctionsRepositoryImpl implements PostAuctionsRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    @Transactional
    public PostAuctionKey addPostAuction(PostAuction postAuction) {
        Session session = sessionFactory.getObject().getCurrentSession();
        session.save(postAuction);
        return postAuction.getId();
    }

    @Override
    @Transactional
    public List<PostAuction> getPostAuctions(int post_id) {
        Session session = sessionFactory.getObject().getCurrentSession();

//        session.createQuery("from PostAuction where ")
        return null;
    }
}
