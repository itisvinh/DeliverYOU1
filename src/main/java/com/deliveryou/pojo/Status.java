package com.deliveryou.pojo;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class Status {
    @Transient
    public static final String CANCELED = "CANCELED";
    @Transient
    public static final String DELIVERED = "DELIVERED";
    @Transient
    public static final String ONGOING = "ONGOING";
    @Transient
    public static final String PENDING = "PENDING";


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "status_id")
    private int statusId;
    @Basic
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "status")
    private List<Post> posts;

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Status)) return false;
        Status status = (Status) o;
        return statusId == status.statusId && name.equals(status.name) && Objects.equals(posts, status.posts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusId, name, posts);
    }
}
