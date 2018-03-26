package com.kakaoproject.coupon.service;

import com.kakaoproject.coupon.domain.Coupon;
import com.kakaoproject.coupon.domain.CouponIssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.kakaoproject.coupon.utility.commonUtil.generateCouponRandomizedString;

@Service
public class CouponIssueService {

    @Autowired
    CouponIssueRepository couponIssueRepository;

    public void issueCoupon(String email) {
         couponIssueRepository.save(new Coupon(email, generateCoupon()));
    }

    public String getIssuedCouponList() {
        return ((List<Coupon>) couponIssueRepository.findAll()).get(0).getCoupon();
    }

    private String generateCoupon() {
        return generateCouponRandomizedString();
    }
}
