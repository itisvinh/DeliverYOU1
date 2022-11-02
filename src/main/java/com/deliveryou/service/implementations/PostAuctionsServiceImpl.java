package com.deliveryou.service.implementations;

import com.deliveryou.exception.UpdateViolationException;
import com.deliveryou.pojo.PostAuction;
import com.deliveryou.pojo.PostAuctionKey;
import com.deliveryou.repository.interfaces.PostAuctionsRepository;
import com.deliveryou.service.interfaces.PostAuctionsService;
import com.deliveryou.service.interfaces.PostService;
import com.deliveryou.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class PostAuctionsServiceImpl implements PostAuctionsService {
    @Autowired
    private PostAuctionsRepository postAuctionsRepositoryImpl;
    @Autowired
    private PostService postServiceImpl;
    @Autowired
    private UserService userServiceImpl;

    @Override
    @Transactional
    public PostAuctionKey addPostAuction(PostAuction postAuction) {
        return postAuctionsRepositoryImpl.addPostAuction(postAuction);
    }

    @Override
    @Transactional
    public List<PostAuction> getPostAuctions(int post_id) {
        PostAuction p = postAuctionsRepositoryImpl.getAssignedPostAuction(post_id);

        if (p == null) {
            List<PostAuction> list = postAuctionsRepositoryImpl.getPostAuctions(post_id);
            return (list != null && list.size() > 0) ? list : null;
        }
        return Arrays.asList(p);
    }

    @Override
    @Transactional
    public PostAuction assignPostAuction(PostAuction postAuction) throws UpdateViolationException {
        PostAuction p = postAuctionsRepositoryImpl.getAssignedPostAuction(postAuction.getId().getPostId());

        if (p == null) {
            postAuction.setUserAccepted(true);
            return postAuctionsRepositoryImpl.assignPostAuction(postAuction);
        } else {
            throw new UpdateViolationException("The post ID=[" + p.getPost().getId() + "] is already assigned with shipper ID=[" + p.getShipper().getId() + "]");
        }
    }

    @Override
    @Transactional
    public long getNumberOfPostAuctions(int post_id) {
        return postAuctionsRepositoryImpl.getNumberOfPostAuctions(post_id);
    }

    @Override
    public PostAuction getPostAuction(PostAuctionKey postAuctionKey) {
        return postAuctionsRepositoryImpl.getPostAuction(postAuctionKey);
    }

    @Override
    public boolean updatePostAuction(PostAuction postAuction) {
        return postAuctionsRepositoryImpl.updatePostAuction(postAuction);
    }

    @Override
    public PostAuction getAssignedPostAuction(int post_id) {
        return postAuctionsRepositoryImpl.getAssignedPostAuction(post_id);
    }
}
