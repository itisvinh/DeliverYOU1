package com.deliveryou.service.interfaces;

import com.deliveryou.pojo.Post;
import com.deliveryou.pojo.PostAuction;
import com.deliveryou.pojo.PostAuctionKey;

import java.util.List;

public interface PostAuctionsService {
    PostAuctionKey addPostAuction(PostAuction postAuction);

    List<PostAuction> getPostAuctions(int post_id);
}
