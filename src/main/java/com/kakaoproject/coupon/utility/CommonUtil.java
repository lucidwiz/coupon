package com.kakaoproject.coupon.utility;

import javax.mail.internet.InternetAddress;
import java.util.Random;
import javax.mail.internet.AddressException;

public class CommonUtil {

    private static final Random RND = new Random(System.currentTimeMillis());
    private static final String CHAR_SET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int NUMERIC_STEP = 4;
    private static final int TOTAL_LENGTH = 16;
    private static final String SEPARATOR = "-";

    // Generate randomized coupon string
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

    // Validate email string using javax.mail package
    public static boolean isValidEmailAddress(String email) throws AddressException {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }
}
