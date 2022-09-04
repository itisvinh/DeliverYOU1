package com.deliveryou.pojo;

import javax.persistence.*;

@Entity
@Table(name = "post_image", schema = "deliveryou", catalog = "")
public class PostImage {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "image")
    private String image;
    @Basic
    @Column(name = "post_id")
    private int postId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostImage postImage = (PostImage) o;

        if (id != postImage.id) return false;
        if (postId != postImage.postId) return false;
        if (image != null ? !image.equals(postImage.image) : postImage.image != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + postId;
        return result;
    }
}
