package com.deliveryou.pojo.deliveryobject;

import com.deliveryou.pojo.Post;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PostDeliveryObject {
    @JsonProperty("senderProvince")
    private String senderProvince;
    private String senderDistrict;
    private String senderWard;
    private String senderStreet;
    private Integer senderId;

    private String receiverProvince;
    private String receiverDistrict;
    private String receiverWard;
    private String receiverStreet;
    private String receiverName;
    private String receiverPhone;

    private String postContent;
    private String categoryName;
    private List<String> urlList;


    public List<String> getUrlList() {
        return urlList;
    }

    public void setUrlList(List<String> urlList) {
        this.urlList = urlList;
    }

    public String getSenderProvince() {
        return senderProvince;
    }

    public void setSenderProvince(String senderProvince) {
        this.senderProvince = senderProvince;
    }

    public String getSenderDistrict() {
        return senderDistrict;
    }

    public void setSenderDistrict(String senderDistrict) {
        this.senderDistrict = senderDistrict;
    }

    public String getSenderWard() {
        return senderWard;
    }

    public void setSenderWard(String senderWard) {
        this.senderWard = senderWard;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public String getReceiverProvince() {
        return receiverProvince;
    }

    public void setReceiverProvince(String receiverProvince) {
        this.receiverProvince = receiverProvince;
    }

    public String getReceiverDistrict() {
        return receiverDistrict;
    }

    public void setReceiverDistrict(String receiverDistrict) {
        this.receiverDistrict = receiverDistrict;
    }

    public String getReceiverWard() {
        return receiverWard;
    }

    public void setReceiverWard(String receiverWard) {
        this.receiverWard = receiverWard;
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

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getSenderStreet() {
        return senderStreet;
    }

    public void setSenderStreet(String senderStreet) {
        this.senderStreet = senderStreet;
    }

    public String getReceiverStreet() {
        return receiverStreet;
    }

    public void setReceiverStreet(String receiverStreet) {
        this.receiverStreet = receiverStreet;
    }

    @Override
    public String toString() {
//        List<String> url_list = (urlList != null && urlList.length() > 0) ?
//                Arrays.asList(urlList.split("<split/>")) : null;
        return "PostDeliveryObject{" +
                "senderProvince='" + senderProvince + '\'' +
                ", senderDistrict='" + senderDistrict + '\'' +
                ", senderWard='" + senderWard + '\'' +
                ", senderStreet='" + senderStreet + '\'' +
                ", senderId=" + senderId +
                ", receiverProvince='" + receiverProvince + '\'' +
                ", receiverDistrict='" + receiverDistrict + '\'' +
                ", receiverWard='" + receiverWard + '\'' +
                ", receiverStreet='" + receiverStreet + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", receiverPhone='" + receiverPhone + '\'' +
                ", postContent='" + postContent + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", urlList='" + urlList + '\'' +
                '}';
    }

}
