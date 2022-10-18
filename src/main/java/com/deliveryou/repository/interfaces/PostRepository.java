package com.deliveryou.repository.interfaces;

import com.deliveryou.pojo.Post;
import com.deliveryou.pojo.Status;

import java.util.List;

public interface PostRepository {
    List<Post> getAllPosts();
    List<Post> getPostsWithinRange(Status status, int startResult, int maxResults);
    Post getPost(int id);
    int addPost(Post post);

    long getTotalPosts();
//    List<Post> getPendingPosts();

    List<Post> getPendingPosts(String shipperPhone);

    List<Post> getNotAcceptedPost(String shipperPhone);

    List<Post> getUserAcceptedPostsForShipper(String shipperPhone);

    boolean updatePostState(Post post);
}
