package com.deliveryou.pojo;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "address", schema = "deliveryou")
public class Address {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "province")
    private String province;
    @Basic
    @Column(name = "district")
    private String district;
    @Basic
    @Column(name = "ward")
    private String ward;
    @Basic
    @Column(name = "street")
    private String street;
    @OneToMany(mappedBy = "senderAddress")
    private Collection<Post> postsById;
    @OneToMany(mappedBy = "receiverAddress")
    private Collection<Post> postsById_0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (id != address.id) return false;
        if (province != null ? !province.equals(address.province) : address.province != null) return false;
        if (district != null ? !district.equals(address.district) : address.district != null) return false;
        if (ward != null ? !ward.equals(address.ward) : address.ward != null) return false;
        if (street != null ? !street.equals(address.street) : address.street != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (province != null ? province.hashCode() : 0);
        result = 31 * result + (district != null ? district.hashCode() : 0);
        result = 31 * result + (ward != null ? ward.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        return result;
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
}
