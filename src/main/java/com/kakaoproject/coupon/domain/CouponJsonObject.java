package com.kakaoproject.coupon.domain;

import java.util.List;

public class CouponJsonObject {

    // Total count of elements
    private int count;

    // ArrayList of issued coupons
    private List<Coupon> couponList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Coupon> getCouponList() {
        return couponList;
    }

    public void setCouponList(List<Coupon> couponList) {
        this.couponList = couponList;
    }
}
