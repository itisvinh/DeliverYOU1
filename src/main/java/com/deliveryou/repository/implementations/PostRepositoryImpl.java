package com.deliveryou.repository.implementations;

import com.deliveryou.pojo.Category;
import com.deliveryou.pojo.Post;
import com.deliveryou.pojo.Status;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostRepositoryImpl implements com.deliveryou.repository.interfaces.PostRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Post> getAllPosts() {
        Session session = sessionFactory.getObject().getCurrentSession();
        return session.createQuery("from Post").getResultList();
    }

    @Override
    public List<Post> getPostsWithinRange(Status status, int startResult, int maxResults) {
        Session session = sessionFactory.getObject().getCurrentSession();

        Query query = session.createQuery("from Post " +
                "where status.name = :sname or status.id = :sid " +
                "order by orderDate desc");
        query.setParameter("sname", status.getName());
        query.setParameter("sid", status.getStatusId());
        query.setFirstResult(startResult);
        query.setMaxResults(maxResults);
        return query.getResultList();
    }

    @Override
    public Post getPost(int id) {
        Session session = sessionFactory.getObject().getCurrentSession();
        try {
            return session.get(Post.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public int addPost(Post post) {
        Session session = sessionFactory.getObject().getCurrentSession();
        try {
            session.save(post);
            return post.getId();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    @Override
    public long getTotalPosts() {
        Session session = sessionFactory.getObject().getCurrentSession();
        try {
            return (Long) session.createQuery("select count(*) from Post").getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }


}
