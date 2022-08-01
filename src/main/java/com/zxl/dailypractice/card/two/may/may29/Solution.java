package com.zxl.dailypractice.card.two.may.may29;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/5/29
 * @Version 1.0
 **/
//验证IP地址    https://leetcode.cn/problems/validate-ip-address/
public class Solution {
    public String validIPAddress(String queryIP) {
        String ipv4Pattern = "((2(5[0-5]|[0-4]\\d))|(1([0-9][0-9]))|[1-9][0-9]?|[0-9])(.((2(5[0-5]|[0-4]\\d))|(1([0-9][0-9]))|[1-9][0-9]?|[0-9])){3}";
        String ipv6Pattern = "([0-9a-fA-F]{1,4})(:[0-9a-fA-F]{1,4}){7}";

        if(queryIP.indexOf(".") > 0 && (queryIP.matches(ipv4Pattern))){
            return "IPv4";
        }
        if(queryIP.indexOf(":") > 0 && (queryIP.matches(ipv6Pattern))){
            return "IPv6";
        }
        return "Neither";
    }
}
