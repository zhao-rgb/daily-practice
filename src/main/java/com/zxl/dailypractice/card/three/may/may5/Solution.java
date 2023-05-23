package com.zxl.dailypractice.card.three.may.may5;

/**
 * @author: zhaoxl
 * @date: 2023/5/4
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) {
//        String[] test = {"1","2","3"};
//        String str = "";
//        for (String t : test){
//            str += t + "\r\n";
//        }
//        String substring = str.substring(0, str.length() - 1);
//        System.out.print(substring);

        String a = "http://121.5.129.115:8081/sysUser/login";
        String[] split = a.split(":");
        String replace = split[1].replace("/", "");
        System.out.println(replace);
    }
}
