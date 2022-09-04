package com.deliveryou.repository.implementations;

import com.deliveryou.pojo.Post;
import org.hibernate.Session;
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
    public List<Post> getPostsWithinRange(int start, int end) {
        return null;
    }

    @Override
    public Post getPost(int id) {
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
}
