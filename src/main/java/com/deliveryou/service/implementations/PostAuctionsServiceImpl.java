package com.deliveryou.service.implementations;

import com.deliveryou.pojo.PostAuction;
import com.deliveryou.repository.interfaces.PostAuctionsRepository;
import com.deliveryou.service.interfaces.PostAuctionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PostAuctionsServiceImpl implements PostAuctionsService {
    @Autowired
    private PostAuctionsRepository postAuctionsRepositoryImpl;

    @Override
    public int addPostAuction(PostAuction postAuction) {
        return postAuctionsRepositoryImpl.addPostAuction(postAuction);
    }

    @Override
    public List<PostAuction> getPostAuctions(int post_id) {
        return postAuctionsRepositoryImpl.getPostAuctions(post_id);
    }
}
