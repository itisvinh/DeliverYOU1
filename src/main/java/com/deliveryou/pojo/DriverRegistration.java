package com.deliveryou.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "driver_registration", schema = "deliveryou")
public class DriverRegistration {
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
    @Column(name = "citizen_id")
    private String citizenId;
    @Basic
    @Column(name = "avatar")
    private String avatar;
    @Basic
    @Column(name = "is_processed")
    private byte isProcessed;
    @Basic
    @Column(name = "message")
    private String message;

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

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

    public String getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(String citizenId) {
        this.citizenId = citizenId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public byte getIsProcessed() {
        return isProcessed;
    }

    public void setIsProcessed(byte isProcessed) {
        this.isProcessed = isProcessed;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DriverRegistration)) return false;
        DriverRegistration that = (DriverRegistration) o;
        return id == that.id && isProcessed == that.isProcessed && firstname.equals(that.firstname) && lastname.equals(that.lastname) && Objects.equals(email, that.email) && phoneNumber.equals(that.phoneNumber) && citizenId.equals(that.citizenId) && avatar.equals(that.avatar) && Objects.equals(message, that.message) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, email, phoneNumber, citizenId, avatar, isProcessed, message, address);
    }
}
