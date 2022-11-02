package com.deliveryou.service.interfaces;

import com.deliveryou.pojo.Post;
import com.deliveryou.pojo.PostAuction;
import com.deliveryou.pojo.PostAuctionKey;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PostAuctionsService {
    PostAuctionKey addPostAuction(PostAuction postAuction);

    List<PostAuction> getPostAuctions(int post_id);

    @Transactional
    PostAuction assignPostAuction(PostAuction postAuction);

    @Transactional
    long getNumberOfPostAuctions(int post_id);

    public PostAuction getPostAuction(PostAuctionKey postAuctionKey);

    boolean updatePostAuction(PostAuction postAuction);

    PostAuction getAssignedPostAuction(int post_id);
}
