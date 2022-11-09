package com.zxl.dailypractice.card.two.november.november8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: zhaoxl
 * @date: 2022/11/3
 * @desc:
 **/
//统计一致字符串的数目       https://leetcode.cn/problems/count-the-number-of-consistent-strings/
public class Solution {
    public static void main(String[] args) {
        System.out.println(System.getProperty("usr.home", "/slview"));
        List<Map<String, Object>> resultMapList = new ArrayList<>();
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("1","赵肖龙");
        resultMapList.add(dataMap);
        //todo 解决
        dataMap = new HashMap<String, Object>();
        dataMap.put("1","哈哈哈");
        resultMapList.add(dataMap);
        System.out.println(dataMap);
        System.out.println(resultMapList);
    }

    public int countConsistentStrings(String allowed, String[] words) {
        int mask = 0;
        for (int i = 0; i < allowed.length(); i++) {
            char c = allowed.charAt(i);
            mask |= 1 << (c - 'a');
        }
        int res = 0;
        for (String word : words) {
            int mask1 = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                mask1 |= 1 << (c - 'a');
            }
            if ((mask1 | mask) == mask) {
                res++;
            }
        }
        return res;
    }
}
