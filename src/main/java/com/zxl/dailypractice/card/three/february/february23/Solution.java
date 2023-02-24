package com.zxl.dailypractice.card.three.february.february23;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhaoxl
 * @date: 2023/2/23
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) {
        Map<Object, Integer> timeMap = new HashMap<>();
        timeMap.put(2,3);
        timeMap.put(1,3);
        if (timeMap.containsKey(2)){
            timeMap.put(2,timeMap.get(2) + 3);
        }
    }
}
