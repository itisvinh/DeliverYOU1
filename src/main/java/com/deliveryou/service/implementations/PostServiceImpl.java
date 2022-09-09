package com.deliveryou.service.implementations;

import com.deliveryou.pojo.Post;
import com.deliveryou.pojo.Status;
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
    @Transactional
    public List<Post> getAllPosts() {
        return postRepositoryImpl.getAllPosts();
    }

    @Override
    @Transactional
    public List<Post> getPostsWithinRange(Status status, int startResult, int maxResults) {
        return postRepositoryImpl.getPostsWithinRange(status, startResult, maxResults);
    }

    @Override
    public long getTotalPosts() {
        return postRepositoryImpl.getTotalPosts();
    }

    @Override
    public Post getPost(int id) {
        return postRepositoryImpl.getPost(id);
    }
}
