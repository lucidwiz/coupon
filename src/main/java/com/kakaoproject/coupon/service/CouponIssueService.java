package com.kakaoproject.coupon.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kakaoproject.coupon.domain.Coupon;
import com.kakaoproject.coupon.domain.CouponIssueRepository;
import com.kakaoproject.coupon.domain.CouponJsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.internet.AddressException;
import java.util.List;

import static com.kakaoproject.coupon.utility.CommonUtil.generateCouponRandomizedString;
import static com.kakaoproject.coupon.utility.CommonUtil.isValidEmailAddress;

@Service
public class CouponIssueService {

    @Autowired
    CouponIssueRepository couponIssueRepository;

    private ObjectMapper mapper = new ObjectMapper();

    public void issueCoupon(String email) throws AddressException {
        // Email string validation
        if (isValidEmailAddress(email)) {
            try {
                // Insert coupon information to database
                couponIssueRepository.save(new Coupon(email, generateCoupon()));
            } catch (org.hibernate.exception.ConstraintViolationException ex) {
                throw ex;
            }
        }
    }

    public String getIssuedCouponList() throws JsonProcessingException {
        // Find all of coupon list from entity
        List<Coupon> resultList = (List<Coupon>) couponIssueRepository.findAll();

        // Make JSON Object for result
        CouponJsonObject couponJsonObject = new CouponJsonObject();
        String jsonObject;

        // Set elements to object
        couponJsonObject.setCount(resultList.size());
        couponJsonObject.setCouponList(resultList);

        try {
            // Jackson JSON write to object
            jsonObject = mapper.writeValueAsString(couponJsonObject);
        } catch (JsonProcessingException ex) {
            throw ex;
        }

        return jsonObject;
    }

    private String generateCoupon() {
        // Generate randomized coupon string
        return generateCouponRandomizedString();
    }
}
