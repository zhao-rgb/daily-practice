package com.zxl.dailypractice.card.three.nine.nine6;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author: zhaoxl
 * @date: 2023/9/5
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) {
        BigDecimal a = BigDecimal.valueOf(14);
        BigDecimal b = BigDecimal.valueOf(16);
        System.out.println(a.divide(b, 2, RoundingMode.HALF_UP).toString());


        String dateString = "2023-09-13 16:08:37.0";

        // 使用字符串截取将日期提取出来
        String formattedDate = dateString.substring(0, 10);
        System.out.println(formattedDate);

//        Integer freepaceNum = 20;
//        Integer chargeSpaceNum = 4;
//
//        BigDecimal freepaceBigDecimal = new BigDecimal(freepaceNum);
//        BigDecimal chargeSpaceBigDecimal = new BigDecimal(chargeSpaceNum);
//
//        BigDecimal inputBigDecimal = BigDecimal.ZERO;
//
//        if (!chargeSpaceBigDecimal.equals(BigDecimal.ZERO)) {
//            inputBigDecimal = freepaceBigDecimal.divide(chargeSpaceBigDecimal, 2, RoundingMode.HALF_UP);
//            inputBigDecimal = inputBigDecimal.min(BigDecimal.valueOf(1.2));
//        }
//
//        System.out.println(inputBigDecimal);
//
//        double rate = Double.parseDouble(String.valueOf(0.82222222222222));
//        System.out.println(new DecimalFormat("#.00").format(rate*100));
    }
}
