package com.kakaoproject.coupon.controller;

import com.kakaoproject.coupon.domain.CouponIssueRepository;
import com.kakaoproject.coupon.service.CouponIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.kakaoproject.coupon.utility.commonUtil.generateCouponRandomizedString;

@RestController
@Component
public class CouponIssueController {

    CouponIssueService couponIssueService = new CouponIssueService();

    @RequestMapping("/issue")
    public void issueCouponController(@RequestParam(value = "email") String email) {
        couponIssueService.issueCoupon(email);
    }

    @RequestMapping("/getlist")
    public String getIssuedCouponListController() {
        return couponIssueService.getIssuedCouponList();
    }

    private String generateCoupon() {
        return generateCouponRandomizedString();
    }
}
