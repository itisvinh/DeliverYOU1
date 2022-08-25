package com.deliveryou.pojo;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "tokens")
public class Tokens {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "token_id")
    private int tokenId;
    @Basic
    @Column(name = "token")
    private String token;
    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Basic
    @Column(name = "expired_at")
    private Timestamp expiredAt;
    @Basic
    @Column(name = "confirm_at")
    private Timestamp confirmAt;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public int getTokenId() {
        return tokenId;
    }

    public void setTokenId(int tokenId) {
        this.tokenId = tokenId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(Timestamp expiredAt) {
        this.expiredAt = expiredAt;
    }

    public Timestamp getConfirmAt() {
        return confirmAt;
    }

    public void setConfirmAt(Timestamp confirmAt) {
        this.confirmAt = confirmAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tokens tokens = (Tokens) o;

        if (tokenId != tokens.tokenId) return false;
        if (token != null ? !token.equals(tokens.token) : tokens.token != null) return false;
        if (createdAt != null ? !createdAt.equals(tokens.createdAt) : tokens.createdAt != null) return false;
        if (expiredAt != null ? !expiredAt.equals(tokens.expiredAt) : tokens.expiredAt != null) return false;
        if (confirmAt != null ? !confirmAt.equals(tokens.confirmAt) : tokens.confirmAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tokenId;
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (expiredAt != null ? expiredAt.hashCode() : 0);
        result = 31 * result + (confirmAt != null ? confirmAt.hashCode() : 0);
        return result;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
