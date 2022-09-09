package com.deliveryou.service.interfaces;

import com.deliveryou.pojo.Post;
import com.deliveryou.pojo.Status;

import java.util.List;

public interface PostService {
    int addPost(Post post);
    List<Post> getAllPosts();
    List<Post> getPostsWithinRange(Status status, int startResult, int maxResults);

    long getTotalPosts();

    Post getPost(int id);

}
