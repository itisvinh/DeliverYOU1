package com.deliveryou.pojo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RatingKey implements Serializable {
    private static final long serialVersionUID = 5651712985022374266L;
    @Column(name = "user_id")
    private int userId;

    @Column(name = "shipper_id")
    private int shipperId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
        RatingKey ratingKey = (RatingKey) o;
        return userId == ratingKey.userId && shipperId == ratingKey.shipperId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, shipperId);
    }
}
