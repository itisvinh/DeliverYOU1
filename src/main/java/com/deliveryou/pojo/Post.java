package com.deliveryou.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Post {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "receiver_name")
    private String receiverName;
    @Basic
    @Column(name = "receiver_phone")
    private String receiverPhone;
    @Basic
    @Column(name = "content")
    private String content;
    @Basic
    @Column(name = "order_date")
    private Timestamp orderDate;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "shipper_id", referencedColumnName = "id")
    private User shipper;
    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "status_id", nullable = false)
    private Status status;
    @ManyToOne
    @JoinColumn(name = "payment_method_id", referencedColumnName = "id", nullable = false)
    private PaymentMethod paymentMethod;
    @ManyToOne
    @JoinColumn(name = "promotion_id", referencedColumnName = "id")
    private Promotion promotion;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private Category category;
    @ManyToOne
    @JoinColumn(name = "sender_address_id", referencedColumnName = "id", nullable = false)
    private Address senderAddress;
    @ManyToOne
    @JoinColumn(name = "receiver_address_id", referencedColumnName = "id", nullable = false)
    private Address receiverAddress;
    @OneToMany(mappedBy = "post")
    private List<PostAuction> postAuctions;
    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
    private List<PostImage> postImages;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return id == post.id && receiverName.equals(post.receiverName) && receiverPhone.equals(post.receiverPhone) && Objects.equals(content, post.content) && orderDate.equals(post.orderDate) && user.equals(post.user) && Objects.equals(shipper, post.shipper) && status.equals(post.status) && paymentMethod.equals(post.paymentMethod) && Objects.equals(promotion, post.promotion) && category.equals(post.category) && senderAddress.equals(post.senderAddress) && receiverAddress.equals(post.receiverAddress) && Objects.equals(postAuctions, post.postAuctions) && Objects.equals(postImages, post.postImages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, receiverName, receiverPhone, content, orderDate, user, shipper, status, paymentMethod, promotion, category, senderAddress, receiverAddress, postAuctions, postImages);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getShipper() {
        return shipper;
    }

    public void setShipper(User shipper) {
        this.shipper = shipper;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public List<PostAuction> getPostAuctions() {
        return postAuctions;
    }

    public void setPostAuctions(List<PostAuction> postAuctions) {
        this.postAuctions = postAuctions;
    }

    public List<PostImage> getPostImages() {
        return postImages;
    }

    public void setPostImages(List<PostImage> postImages) {
        this.postImages = postImages;
    }
}
