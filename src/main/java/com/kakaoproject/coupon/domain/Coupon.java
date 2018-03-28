package com.kakaoproject.coupon.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "ISSUED_COUPON_LIST")
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
    private Date issued_time;

    public Coupon() {
        super();
    }

    public Coupon(String email, String coupon) {
        super();
        this.email = email;
        this.coupon = coupon;
        this.issued_time = new Date();
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
        return issued_time.toString();
    }

    public void setIssued_time(Date issued_time) {
        this.issued_time = issued_time;
    }
}
