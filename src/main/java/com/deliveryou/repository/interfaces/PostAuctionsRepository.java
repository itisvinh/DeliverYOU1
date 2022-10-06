package com.deliveryou.repository.interfaces;

import com.deliveryou.pojo.PostAuction;
import com.deliveryou.pojo.PostAuctionKey;

import java.util.List;

public interface PostAuctionsRepository {
    PostAuctionKey addPostAuction(PostAuction postAuction);

    List<PostAuction> getPostAuctions(int post_id);
}
