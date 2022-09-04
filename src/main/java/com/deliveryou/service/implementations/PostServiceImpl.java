package com.deliveryou.service.implementations;

import com.deliveryou.pojo.Post;
import com.deliveryou.repository.interfaces.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements com.deliveryou.service.interfaces.PostService {
    @Autowired
    private PostRepository postRepositoryImpl;

    @Override
    public int addPost(Post post) {
        return postRepositoryImpl.addPost(post);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepositoryImpl.getAllPosts();
    }
}
