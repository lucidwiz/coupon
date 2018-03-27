package com.kakaoproject.coupon.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponIssueRepository extends CrudRepository<Coupon, Long> {
}

