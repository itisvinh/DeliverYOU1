package com.deliveryou.repository.interfaces;

import com.deliveryou.pojo.Post;

import java.util.List;

public interface PostRepository {
    List<Post> getAllPosts();
    List<Post> getPostsWithinRange(int start, int end);
    Post getPost(int id);

    int addPost(Post post);
}
