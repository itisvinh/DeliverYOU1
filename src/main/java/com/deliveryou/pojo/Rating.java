package com.deliveryou.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Rating {
    @EmbeddedId
    RatingKey id;

    @Basic
    @Column(name = "comment")
    private String comment;

    @Basic
    @Column(name = "rate")
    private int rate;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("shipperId")
    @JoinColumn(name = "shipper_id")
    private User shipper;


    public RatingKey getId() {
        return id;
    }

    public void setId(RatingKey id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getShipper() {
        return shipper;
    }

    public void setShipper(User shipper) {
        this.shipper = shipper;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rating)) return false;
        Rating rating = (Rating) o;
        return rate == rating.rate && Objects.equals(id, rating.id) && Objects.equals(comment, rating.comment) && user.equals(rating.user) && shipper.equals(rating.shipper);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, comment, rate, user, shipper);
    }
}
