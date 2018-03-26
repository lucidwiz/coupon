package com.kakaoproject.coupon.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Coupon {
    @Id
    @GeneratedValue
    private long id;
    private String email;
    private String coupon;
    private Date issued_time;

    public Coupon() {
        super();
    }

    public Coupon(String email, String coupon) {
        super();
        this.email = email;
        this.coupon = coupon;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public Date getIssued_time() {
        return issued_time;
    }

    public void setIssued_time(Date issued_time) {
        this.issued_time = issued_time;
    }
}
