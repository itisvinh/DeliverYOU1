package com.deliveryou.service.interfaces;

import com.deliveryou.pojo.Post;

import java.util.List;

public interface PostService {
    int addPost(Post post);
    List<Post> getAllPosts();
}
