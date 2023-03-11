package com.zxl.dailypractice.card.three.march.march10;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: zhaoxl
 * @date: 2023/3/10
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long currentTime = new Date().getTime();
        long createTime = sdf.parse("2023-03-03 15:46:34").getTime();
        long checkTime = sdf.parse("2023-03-04 15:46:34").getTime();
        System.out.println(createTime);
        System.out.println(checkTime);
        System.out.println((checkTime - createTime)/1000/60/60);
    }
}
