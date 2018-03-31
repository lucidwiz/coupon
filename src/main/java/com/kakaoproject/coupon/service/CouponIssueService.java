package com.kakaoproject.coupon.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kakaoproject.coupon.entity.Coupon;
import com.kakaoproject.coupon.exception.InvalidEmailException;
import com.kakaoproject.coupon.exception.JsonException;
import com.kakaoproject.coupon.repository.CouponIssueRepository;
import com.kakaoproject.coupon.dto.CouponDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.internet.AddressException;

import static com.kakaoproject.coupon.utility.CommonUtil.generateCouponRandomizedString;
import static com.kakaoproject.coupon.utility.CommonUtil.isValidEmailAddress;

@SuppressWarnings("deprecation")
@Service
public class CouponIssueService {

    @Autowired
    CouponIssueRepository couponIssueRepository;

    private ObjectMapper mapper = new ObjectMapper();

    @Transactional
    public void issueCoupon(String email) throws AddressException {
        // Email string validation
        if (isValidEmailAddress(email)) {
            try {
                // Insert coupon information to database
                couponIssueRepository.save(new Coupon(email, generateCoupon()));
            } catch (org.hibernate.exception.ConstraintViolationException ex) {
                throw new InvalidEmailException(email);
            }
        }
    }

    public String getIssuedCouponList(int pagenum, int pagesize) throws JsonProcessingException {
        // Find all of coupon list from entity
        PageRequest request = new PageRequest(pagesize, pagenum);
        Page<Coupon> resultList = couponIssueRepository.findAll(request);
        // Find number of coupon items
        long couponCount = couponIssueRepository.count();

        // Make JSON Object for result
        CouponDto couponDto = new CouponDto();
        String jsonObject;

        // Set elements to object
        couponDto.setCount(couponCount);
        couponDto.setCouponList(resultList.getContent());

        try {
            // Jackson JSON write to object
            jsonObject = mapper.writeValueAsString(couponDto);
        } catch (JsonProcessingException ex) {
            throw new JsonException(ex.getMessage());
        }

        return jsonObject;
    }

    private String generateCoupon() {
        // Generate randomized coupon string
        return generateCouponRandomizedString();
    }
}
