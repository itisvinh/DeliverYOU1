package com.deliveryou.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class PostAuctionKey implements Serializable {
    @Column(name = "post_id")
    private int postId;
    @Column(name = "shipper_id")
    private int shipperId;

    public PostAuctionKey() {}

    public PostAuctionKey(int postId, int shipperId) {
        this.postId = postId;
        this.shipperId = shipperId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getShipperId() {
        return shipperId;
    }

    public void setShipperId(int shipperId) {
        this.shipperId = shipperId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostAuctionKey that = (PostAuctionKey) o;

        if (postId != that.postId) return false;
        if (shipperId != that.shipperId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = postId;
        result = 31 * result + shipperId;
        return result;
    }
}
