package com.zxl.dailypractice.card.three.april.april28;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @author: zhaoxl
 * @date: 2023/4/28
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) throws Exception {
        MessageDigest sha = MessageDigest.getInstance("SHA");
        sha.update("123".getBytes());
        System.out.println(new BigInteger(sha.digest()).toString(32));
    }
}
