package com.zxl.dailypractice.card.january.january3;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/1/3
 * @Version 1.0
 **/
//一周中的第几天     https://leetcode-cn.com/problems/day-of-the-week/
public class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        /* 输入年份之前的年份的天数贡献 */
        int days = 365 * (year - 1971) + (year - 1969) / 4;
        /* 输入年份中，输入月份之前的月份的天数贡献 */
        for (int i = 0; i < month-1; i++) {
            days += monthDays[i];
        }
        if ((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && month >= 3){
            days += 1;
        }
        //输入月份中的天数贡献
        days += day;
        return week[(days + 3) % 7];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.dayOfTheWeek(31, 8, 2019);
        System.out.println(s);
    }
}
