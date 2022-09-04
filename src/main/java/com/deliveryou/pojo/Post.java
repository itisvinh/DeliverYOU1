package com.deliveryou.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

public class Post {
    private int id;
    private String content;
    private Address senderAddress;
    private Address receiverAddress;
    private User sender;
    private String receiverName;
    private String receiverPhone;
    private Category category;
    private List<String> imageUrls;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Address getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(Address senderAddress) {
        this.senderAddress = senderAddress;
    }

    public Address getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(Address receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", senderAddress=" + senderAddress +
                ", receiverAddress=" + receiverAddress +
                ", sender=" + sender +
                ", receiverName='" + receiverName + '\'' +
                ", receiverPhone='" + receiverPhone + '\'' +
                ", category=" + category +
                ", imageUrls=" + imageUrls +
                '}';
    }
}
