package com.deliveryou.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "post_auction", schema = "deliveryou")
public class PostAuction {
    @EmbeddedId
    PostAuctionKey id;

    @Basic
    @Column(name = "request_time")
    private Timestamp requestTime;

    public boolean isUserAccepted() {
        return userAccepted;
    }

    public void setUserAccepted(boolean userAccepted) {
        this.userAccepted = userAccepted;
    }

    @Basic
    @Column(name = "user_accepted")
    private boolean userAccepted = false;

    @Basic
    @Column(name = "shipping_fee")
    private int shippingFee;

    @ManyToOne
    @MapsId("postId")
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @MapsId("shipperId")
    @JoinColumn(name = "shipper_id")
    private User shipper;

    public Timestamp getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Timestamp requestTime) {
        this.requestTime = requestTime;
    }

    public int getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(int shippingFee) {
        this.shippingFee = shippingFee;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getShipper() {
        return shipper;
    }

    public void setShipper(User shipper) {
        this.shipper = shipper;
    }



    public PostAuctionKey getId() {
        return id;
    }

    public void setId(PostAuctionKey id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostAuction)) return false;
        PostAuction that = (PostAuction) o;
        return userAccepted == that.userAccepted && shippingFee == that.shippingFee && Objects.equals(id, that.id) && requestTime.equals(that.requestTime) && post.equals(that.post) && shipper.equals(that.shipper);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, requestTime, userAccepted, shippingFee, post, shipper);
    }
}
