package com.deliveryou.service.implementations;

import com.deliveryou.pojo.PostImage;
import com.deliveryou.repository.interfaces.PostImageRepository;
import com.deliveryou.service.interfaces.PostImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostImageServiceImpl implements PostImageService {
    @Autowired
    private PostImageRepository postImageRepositoryImpl;

    @Override
    public int addPostImage(PostImage postImage) {
        return postImageRepositoryImpl.addPostImage(postImage);
    }
}
