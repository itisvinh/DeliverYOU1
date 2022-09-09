package com.deliveryou.repository.interfaces;

import com.deliveryou.pojo.PostAuction;

import java.util.List;

public interface PostAuctionsRepository {
    int addPostAuction(PostAuction postAuction);

    List<PostAuction> getPostAuctions(int post_id);
}
