package com.zxl.dailypractice.card.three.april.april4;

import org.apache.commons.lang3.math.NumberUtils;

import java.io.UnsupportedEncodingException;

/**
 * @author: zhaoxl
 * @date: 2023/4/4
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) throws UnsupportedEncodingException {
//        String checkValue = "70";
//        String checkExpr = "80";
//        String checkResult = "0";
//        String checkMethod = ">=";
//        String resultListStatusTrue;
//        if (checkResult.equals("1")){
//            resultListStatusTrue = "0";
//            checkResult = "1";
//        } else {
//            resultListStatusTrue = "1";
//            checkResult = "0";
//        }
//        switch (checkMethod) {
//            case ">=":
//                if (Integer.parseInt(checkValue) >= Integer.parseInt(checkExpr)) {
//                    System.out.println(checkResult);
//                } else {
//                    System.out.println(resultListStatusTrue);
//                }
//                break;
//        }
//        String checkValue = "70a";
//        String checkExpr = "80";
//        String resultExpr = "(\\d*)";
//        Pattern p = Pattern.compile(resultExpr);
//        Matcher matcher = p.matcher(checkValue);
//        System.out.println(matcher.replaceAll(""));

        String fileName = "test - 副本,.txt";
        String newFileName = new String(fileName.getBytes(), "utf-8");
        String replace = fileName.replace(",", "");
        System.out.println(String.format("attachment; filename=\"%s\"", replace));

        if(NumberUtils.isDigits("2222")){
            System.out.println("hhh");
        }
    }
}
