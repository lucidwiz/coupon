package com.kakaoproject.coupon.utility;

import java.util.Random;

public class commonUtil {

    private static final Random RND = new Random(System.currentTimeMillis());
    private static final String CHAR_SET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int NUMERIC_STEP = 4;
    private static final int TOTAL_LENGTH = 16;
    private static final String SEPARATOR = "-";

    public static String generateCouponRandomizedString() {
        StringBuilder resultSB = new StringBuilder();
        char[] charSet = CHAR_SET.toCharArray();

        for (int i = 1 ; i <= TOTAL_LENGTH ; i++) {
            resultSB.append(charSet[RND.nextInt(CHAR_SET.length())]);

            if (i % NUMERIC_STEP == 0 && i != TOTAL_LENGTH) {
                resultSB.append(SEPARATOR);
            }
        }

        return resultSB.toString();
    }
}
