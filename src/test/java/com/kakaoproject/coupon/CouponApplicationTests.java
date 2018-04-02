package com.kakaoproject.coupon;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kakaoproject.coupon.dto.CouponDto;
import com.kakaoproject.coupon.entity.Coupon;
import com.kakaoproject.coupon.utility.CommonUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@EnableAutoConfiguration
@SpringBootTest(classes = CouponApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CouponApplicationTests {

    @LocalServerPort
    private int port;

    private String ISSUE_PATH = "/api/v1/issue/";
    private String GETLIST_PATH = "/api/v1/getlist";

    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();
    HttpEntity<String> entity = new HttpEntity<String>(null, headers);

    @Test
	public void Successfully__issue_coupon_when_email_is_provided() {
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort(ISSUE_PATH + "test@test.com"),
                HttpMethod.POST, entity, String.class);

        assertTrue(response.getStatusCode().equals(HttpStatus.CREATED));

	}

    @Test
    public void Failed__to_issue_coupon_when_email_is_not_provided() {
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort(ISSUE_PATH),
                HttpMethod.POST, entity, String.class);

        assertTrue(response.getStatusCode().equals(HttpStatus.NOT_FOUND));
    }

    @Test
    public void Failed__to_issue_coupon_when_invalid_email_is_provided() {
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort(ISSUE_PATH + "com"),
                HttpMethod.POST, entity, String.class);

        assertTrue(response.getStatusCode().equals(HttpStatus.BAD_REQUEST));
    }

    @Test
    public void Successfully__get_all_of_issued_coupon_list_when_there_is_a_coupon_item() throws JSONException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        ResponseEntity<String> postResponse = restTemplate.exchange(
                createURLWithPort(ISSUE_PATH + "test@test.com"),
                HttpMethod.POST, entity, String.class);

        ResponseEntity<String> getResponse = restTemplate.exchange(
                createURLWithPort(GETLIST_PATH),
                HttpMethod.GET, entity, String.class);

        JSONArray couponJsonArray = new JSONObject(getResponse.getBody()).getJSONArray("couponList");
        JSONObject couponJsonObject = couponJsonArray.getJSONObject(0);

        String expected = objectMapper.writeValueAsString(createCouponDto(
                couponJsonObject.getString("coupon"), couponJsonObject.getString("issued_time")));

        JSONAssert.assertEquals(expected, getResponse.getBody(), false);
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

    private Coupon createCoupon(String couponText, String issued_time) {
        Coupon coupon = new Coupon();

        coupon.setCoupon(couponText);
        coupon.setEmail("test@test.com");
        coupon.setId(1L);
        coupon.setIssued_time(issued_time);

        return coupon;
    }

    private CouponDto createCouponDto(String couponText, String issued_time) {
        CouponDto couponDto = new CouponDto();
        List<Coupon> couponList = new ArrayList<>();

        couponList.add(createCoupon(couponText, issued_time));

        couponDto.setCount(1);
        couponDto.setCouponList(couponList);

        return couponDto;
    }
}
