package com.zxl.dailypractice.card.december.December20;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2021/12/21
 * @Version 1.0
 **/
//一年中的第几天      https://leetcode-cn.com/problems/day-of-the-year/
public class Solution {
    public int dayOfYear(String date) {
        int year = Integer.parseInt(date.substring(0,4));
        int month = Integer.parseInt(date.substring(5,7));
        int day = Integer.parseInt(date.substring(8));

        int[] amount = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            ++amount[1];
        }

        int ans = 0;
        for (int i = 0; i < month-1; i++) {
            ans += amount[i];
        }
        return ans+day;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String str = format.format(new Date());
        System.out.println(str);

        int i = solution.dayOfYear(str);
        System.out.println(i);
    }
}
