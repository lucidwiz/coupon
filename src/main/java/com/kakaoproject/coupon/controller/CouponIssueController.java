package com.kakaoproject.coupon.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kakaoproject.coupon.service.CouponIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.AddressException;

import static com.kakaoproject.coupon.utility.CommonUtil.generateCouponRandomizedString;

@RestController
public class CouponIssueController {

    @Autowired
    CouponIssueService couponIssueService;

    // Coupon issue controller
    @RequestMapping("/issue")
    public String issueCouponController(@RequestParam(value = "email") String email) throws AddressException {
        couponIssueService.issueCoupon(email);

        return "OK";
    }

    // Getting issued coupon list controller
    // return : JSON String
    @RequestMapping("/getlist")
    public String getIssuedCouponListController() throws JsonProcessingException {
        return couponIssueService.getIssuedCouponList();
    }
}
