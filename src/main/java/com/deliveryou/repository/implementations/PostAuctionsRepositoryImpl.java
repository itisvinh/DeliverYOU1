package com.deliveryou.repository.implementations;

import com.deliveryou.pojo.PostAuction;
import com.deliveryou.pojo.PostAuctionKey;
import com.deliveryou.repository.interfaces.PostAuctionsRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
        List<PostAuction> list = session
                                    .createQuery("select p from PostAuction p where p.post.id=:id")
                                    .setParameter("id", post_id)
                                    .getResultList();
//        System.out.println("list: " + list);
        return list;
    }

    @Override
    @Transactional
    public PostAuction getPostAuction(PostAuctionKey postAuctionKey) {
        Session session = sessionFactory.getObject().getCurrentSession();

        try {
            return (PostAuction) session
                    .createQuery("select p from PostAuction p where p.id.postId=:post_id and p.id.shipperId=:shipper_id")
                    .setParameter("post_id", postAuctionKey.getPostId())
                    .setParameter("shipper_id", postAuctionKey.getShipperId())
                    .getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    @Transactional
    public PostAuction getAssignedPostAuction(int post_id) {
        Session session = sessionFactory.getObject().getCurrentSession();
        List<PostAuction> list = session
                                    .createQuery("select p from PostAuction p where p.post.id=:id and p.userAccepted=true")
                                    .setParameter("id", post_id)
                                    .getResultList();
        if (list != null && list.size() > 0)
            return list.get(0);
        return null;
    }

    @Override
    @Transactional
    public PostAuction assignPostAuction(PostAuction postAuction) {
        Session session = sessionFactory.getObject().getCurrentSession();
        return (PostAuction) session.merge(postAuction);
    }

    @Override
    @Transactional
    public long getNumberOfPostAuctions(int post_id) {
        Session session = sessionFactory.getObject().getCurrentSession();

        try {
            return (long) session.createQuery("select count(p) from PostAuction p where p.post.id=:id")
                    .setParameter("id", post_id)
                    .getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    @Override
    public boolean updatePostAuction(PostAuction postAuction) {
        Session session = sessionFactory.getObject().getCurrentSession();
        try {
            session.merge(postAuction);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
