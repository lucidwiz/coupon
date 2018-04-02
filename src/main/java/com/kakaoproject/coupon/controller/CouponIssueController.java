package com.kakaoproject.coupon.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kakaoproject.coupon.service.CouponIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.mail.internet.AddressException;

@RestController
@RequestMapping("/api/v1")
public class CouponIssueController {

    @Autowired
    CouponIssueService couponIssueService;

    // Coupon issue controller
    @PostMapping("/issue/{email}")
    @ResponseStatus(HttpStatus.CREATED)
    public void issueCouponController(@PathVariable String email) throws AddressException {
        couponIssueService.issueCoupon(email);
    }

    // Getting issued coupon list controller
    // return : JSON Object
    @GetMapping("/getlist")
    public String getIssuedCouponListController(
            @RequestParam(value = "pagenum", defaultValue = "0") int pagenum,
            @RequestParam(value = "pagesize", defaultValue = "1") int pagesize) throws JsonProcessingException {
        return couponIssueService.getIssuedCouponList(pagesize, pagenum);
    }
}
