package com.zxl.dailypractice.card.two.november.november11;

/**
 * @author: zhaoxl
 * @date: 2022/11/11
 * @desc:
 **/
//判断字符串的两半是否相似     https://leetcode.cn/problems/determine-if-string-halves-are-alike/
public class Solution {
    public boolean halvesAreAlike(String s) {
        String a = s.substring(0, s.length() / 2);
        String b = s.substring(s.length() / 2);
        String h = "aeiouAEIOU";
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < a.length(); i++) {
            if (h.indexOf(a.charAt(i)) >= 0) {
                sum1++;
            }
        }
        for (int i = 0; i < b.length(); i++) {
            if (h.indexOf(b.charAt(i)) >= 0) {
                sum2++;
            }
        }
        return sum1 == sum2;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                if (i == 1){
                    break;
                }
                System.out.println(i);
            }

        }

    }

//    cmUniNetCutOverTask.setTaskcreateuser("username");
//            cmUniNetCutOverTask.setApplynetuserid("netuserid");
//            cmUniNetCutOverTask.setCanapprovenamelist("username");
//            cmUniNetCutOverTask.setCanapprovenetuseridlist("netuserid");
}
