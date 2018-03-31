package com.kakaoproject.coupon;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CouponApplicationTests {

	@Test
	public void Successfully__issue_coupon_when_email_is_provided() {

	}

    @Test
    public void Failed__to_issue_coupon_when_email_is_not_provided() {

    }

    @Test
    public void Failed__to_issue_coupon_when_invalid_email_is_provided() {

    }

    @Test
    public void Successfully__get_all_of_issued_coupon_list() {

    }

    @Test
    public void Successfully__get_expected_page_of_issued_coupon_list_when_page_number_is_provided() {

    }

    @Test
    public void Successfully__get_expected_page_size_of_issued_coupon_list_when_page_size_is_provided() {

    }
}
