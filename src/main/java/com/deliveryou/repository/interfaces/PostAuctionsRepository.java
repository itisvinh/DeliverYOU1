package com.deliveryou.repository.interfaces;

import com.deliveryou.pojo.PostAuction;
import com.deliveryou.pojo.PostAuctionKey;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PostAuctionsRepository {
    PostAuctionKey addPostAuction(PostAuction postAuction);

    List<PostAuction> getPostAuctions(int post_id);

    @Transactional
    PostAuction getPostAuction(PostAuctionKey postAuctionKey);

    @Transactional
    PostAuction getAssignedPostAuction(int post_id);

    @Transactional
    PostAuction assignPostAuction(PostAuction postAuction);

    @Transactional
    long getNumberOfPostAuctions(int post_id);

    boolean updatePostAuction(PostAuction postAuction);
}
