package com.deliveryou.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "post_image", schema = "deliveryou")
public class PostImage {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "image")
    private String image;
    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id", nullable = false)
    private Post post;

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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostImage)) return false;
        PostImage postImage = (PostImage) o;
        return id == postImage.id && image.equals(postImage.image) && post.equals(postImage.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, image, post);
    }
}
