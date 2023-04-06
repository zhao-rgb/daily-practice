package com.zxl.dailypractice.card.three.april.april4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: zhaoxl
 * @date: 2023/4/4
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) {
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
        String checkValue = "70a";
        String checkExpr = "80";
        String resultExpr = "(\\d*)";
        Pattern p = Pattern.compile(resultExpr);
        Matcher matcher = p.matcher(checkValue);
        System.out.println(matcher.replaceAll(""));
    }
}
