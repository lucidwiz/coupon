package com.kakaoproject.coupon.repository;

import com.kakaoproject.coupon.entity.Coupon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

// JPA repository
@Repository
public interface CouponIssueRepository extends CrudRepository<Coupon, Long>, PagingAndSortingRepository<Coupon, Long> {
}

