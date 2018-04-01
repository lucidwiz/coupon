package com.kakaoproject.coupon.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    private String coupon;

    @NotNull
    private String issued_time;

    public Coupon() {
        super();
    }

    public Coupon(String email, String coupon) {
        super();
        this.email = email;
        this.coupon = coupon;
        this.issued_time = new Date().toString();
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

    public String getIssued_time() {
        return issued_time;
    }

    public void setIssued_time(String issued_time) {
        this.issued_time = issued_time;
    }
}
