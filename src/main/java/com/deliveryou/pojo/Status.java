package com.deliveryou.pojo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "status")
public class Status {
    @Transient
    public static final String ONGOING = "ONGOING";
    @Transient
    public static final String PENDING = "PENDING";
    @Transient
    public static final String DELIVERED = "DELIVERED";
    @Transient
    public static final String CANCELED = "CANCELED";

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "status_id")
    private Integer statusId;
    @Basic
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "status")
    private List<Post> posts;

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Status status = (Status) o;

        if (statusId != null ? !statusId.equals(status.statusId) : status.statusId != null) return false;
        if (name != null ? !name.equals(status.name) : status.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = statusId != null ? statusId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
