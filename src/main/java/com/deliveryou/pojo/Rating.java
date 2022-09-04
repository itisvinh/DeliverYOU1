package com.deliveryou.pojo;

import javax.persistence.*;

@Entity
@IdClass(RatingPK.class)
public class Rating {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id")
    private int userId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "shipper_id")
    private int shipperId;
    @Basic
    @Column(name = "comment")
    private String comment;
    @Basic
    @Column(name = "rate")
    private int rate;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "shipper_id", referencedColumnName = "id", nullable = false)
    private User shipper;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rating rating = (Rating) o;

        if (userId != rating.userId) return false;
        if (shipperId != rating.shipperId) return false;
        if (rate != rating.rate) return false;
        if (comment != null ? !comment.equals(rating.comment) : rating.comment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + shipperId;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + rate;
        return result;
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
}
