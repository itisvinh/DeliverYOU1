package com.deliveryou.pojo;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Promotion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "discount_amount")
    private int discountAmount;
    @Basic
    @Column(name = "deleted")
    private byte deleted;
    @Basic
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "promotion")
    private Collection<Post> postsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    public byte getDeleted() {
        return deleted;
    }

    public void setDeleted(byte deleted) {
        this.deleted = deleted;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Promotion promotion = (Promotion) o;

        if (id != promotion.id) return false;
        if (discountAmount != promotion.discountAmount) return false;
        if (deleted != promotion.deleted) return false;
        if (name != null ? !name.equals(promotion.name) : promotion.name != null) return false;
        if (description != null ? !description.equals(promotion.description) : promotion.description != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + discountAmount;
        result = 31 * result + (int) deleted;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    public Collection<Post> getPostsById() {
        return postsById;
    }

    public void setPostsById(Collection<Post> postsById) {
        this.postsById = postsById;
    }
}
