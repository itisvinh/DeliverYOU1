package com.deliveryou.pojo;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

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
    private List<Post> senderAddresses;
    @OneToMany(mappedBy = "receiverAddress")
    private List<Post> receiverAddresses;


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

    public List<Post> getSenderAddresses() {
        return senderAddresses;
    }

    public void setSenderAddresses(List<Post> senderAddresses) {
        this.senderAddresses = senderAddresses;
    }

    public List<Post> getReceiverAddresses() {
        return receiverAddresses;
    }

    public void setReceiverAddresses(List<Post> receiverAddresses) {
        this.receiverAddresses = receiverAddresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return id == address.id && province.equals(address.province) && district.equals(address.district) && ward.equals(address.ward) && street.equals(address.street) && Objects.equals(senderAddresses, address.senderAddresses) && Objects.equals(receiverAddresses, address.receiverAddresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, province, district, ward, street, senderAddresses, receiverAddresses);
    }
}
