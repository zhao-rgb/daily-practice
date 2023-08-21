package com.zxl.dailypractice.card.three.august.august18;

import java.security.MessageDigest;
import java.time.Instant;

/**
 * @author: zhaoxl
 * @date: 2023/8/18
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) throws Exception {
        String baseUrl = "http://yt.0359v.vip/gw";
        String appId = "a52b2a40b5404b2ab5cb7c55eb0a047e";
        String appSecret = "30662fe3e2cd4ec6b8d775e15c6f55a1";
        String version = "1.0.0";
        long timestamp = Instant.now().getEpochSecond(); // 当前时间戳，精确到秒
        String concatenatedString = "appId=" + appId + "&timestamp=" + timestamp + "&version=" + version + appSecret;
        String sign = calculateMD5(concatenatedString);
        System.out.println(sign);
        System.out.println(concatenatedString);
        System.out.println(System.currentTimeMillis());
    }

    private static String calculateMD5(String input) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(input.getBytes("UTF-8"));
        StringBuilder hexString = new StringBuilder();

        for (byte b : messageDigest) {
            hexString.append(String.format("%02x", b & 0xFF));
        }

        return hexString.toString();
    }

}
