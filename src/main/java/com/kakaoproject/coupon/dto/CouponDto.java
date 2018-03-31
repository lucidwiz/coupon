package com.kakaoproject.coupon.dto;

import com.kakaoproject.coupon.entity.Coupon;

import java.util.List;

public class CouponDto {

    // Total count of elements
    private long count;

    // ArrayList of issued coupons
    private List<Coupon> couponList;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<Coupon> getCouponList() {
        return couponList;
    }

    public void setCouponList(List<Coupon> couponList) {
        this.couponList = couponList;
    }
}
