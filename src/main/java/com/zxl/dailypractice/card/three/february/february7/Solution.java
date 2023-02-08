package com.zxl.dailypractice.card.three.february.february7;

import java.util.regex.Pattern;

/**
 * @author: zhaoxl
 * @date: 2023/2/7
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) {
        //去除数字
        String REGEX = "[^0-9]";
        String ticketStr = "c11";
        String ticket = Pattern.compile(REGEX).matcher(ticketStr).replaceAll("").trim();
        System.out.println(ticket);
    }
}
