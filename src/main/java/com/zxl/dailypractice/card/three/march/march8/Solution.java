package com.zxl.dailypractice.card.three.march.march8;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author: zhaoxl
 * @date: 2023/3/8
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) throws ParseException {
        String time2 = "2023-03-07 11:09:38";
        String starttime = time2.substring(0,10).replace("-", "");
        System.out.println(starttime);
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String now = time.format(formatter);
        String indexName;
        if (now.compareTo(starttime) > 0){
            indexName = "pm_col_vbras_userstatics_*";
        } else {
            indexName = "pm_col_vbras_userstatics_" + now;
        }
        System.out.println(indexName);
    }
}
