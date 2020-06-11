package cn.wyf.httptest.util;

import java.security.MessageDigest;

public class SHA1Util {
    private static final String ALGORITHM = "SHA1";
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};


    private static String byteArrayToHexString(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);

        for (int i = 0; i < len; i++) {
            buf.append(HEX_DIGITS[(bytes[i] >> 4 & 0xF)]);
            buf.append(HEX_DIGITS[(bytes[i] & 0xF)]);
        }
        return buf.toString();
    }


    public static String encode(String str) {
        if (str == null) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(ALGORITHM);
            messageDigest.update(str.getBytes("UTF-8"));
            return byteArrayToHexString(messageDigest.digest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}