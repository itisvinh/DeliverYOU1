package com.deliveryou.pojo;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "firstname")
    private String firstname;
    @Basic
    @Column(name = "lastname")
    private String lastname;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "phone_number")
    private String phoneNumber;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "citizen_id")
    private String citizenId;
    @Basic
    @Column(name = "avatar")
    private int avatar;
    @Basic
    @Column(name = "deleted")
    private byte deleted;
    @OneToMany(mappedBy = "user")
    private Collection<Post> postsById;
    @OneToMany(mappedBy = "shipper")
    private Collection<Post> postsById_0;
    @OneToMany(mappedBy = "shipper")
    private Collection<PostAuction> postAuctionsById;
    @OneToMany(mappedBy = "user")
    private Collection<Rating> ratingsById;
    @OneToMany(mappedBy = "shipper")
    private Collection<Rating> ratingsById_0;
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    private Role roleByRoleId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(String citizenId) {
        this.citizenId = citizenId;
    }


    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public byte getDeleted() {
        return deleted;
    }

    public void setDeleted(byte deleted) {
        this.deleted = deleted;
    }

    public Collection<Post> getPostsById() {
        return postsById;
    }

    public void setPostsById(Collection<Post> postsById) {
        this.postsById = postsById;
    }

    public Collection<Post> getPostsById_0() {
        return postsById_0;
    }

    public void setPostsById_0(Collection<Post> postsById_0) {
        this.postsById_0 = postsById_0;
    }

    public Collection<PostAuction> getPostAuctionsById() {
        return postAuctionsById;
    }

    public void setPostAuctionsById(Collection<PostAuction> postAuctionsById) {
        this.postAuctionsById = postAuctionsById;
    }

    public Collection<Rating> getRatingsById() {
        return ratingsById;
    }

    public void setRatingsById(Collection<Rating> ratingsById) {
        this.ratingsById = ratingsById;
    }

    public Collection<Rating> getRatingsById_0() {
        return ratingsById_0;
    }

    public void setRatingsById_0(Collection<Rating> ratingsById_0) {
        this.ratingsById_0 = ratingsById_0;
    }

    public Role getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(Role roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }
}
