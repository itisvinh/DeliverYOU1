package com.deliveryou.service.interfaces;

import com.deliveryou.pojo.Post;
import com.deliveryou.pojo.PostAuction;

import java.util.List;

public interface PostAuctionsService {
    int addPostAuction(PostAuction postAuction);

    List<PostAuction> getPostAuctions(int post_id);
}
