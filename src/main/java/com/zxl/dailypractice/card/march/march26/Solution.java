package com.zxl.dailypractice.card.march.march26;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/3/26
 * @Version 1.0
 **/
//棒球比赛    https://leetcode-cn.com/problems/baseball-game/
public class Solution {
    public int calPoints(String[] ops) {
        int ret = 0;
        List<Integer> points = new ArrayList<Integer>();
        for (String op : ops){
            int n = points.size();
            switch (op.charAt(0)) {
                case '+':
                    ret += points.get(n-1) + points.get(n-2);
                    points.add(points.get(n-1) + points.get(n-2));
                    break;
                case 'D':
                    ret += 2 * points.get(n-1);
                    points.add(2 * points.get(n-1));
                    break;
                case 'C':
                    ret -= points.get(n-1);
                    points.remove(n-1);
                    break;
                default:
                    ret += Integer.parseInt(op);
                    points.add(Integer.parseInt(op));
                    break;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] op = {"5","2","C","D","+"};
        int i = solution.calPoints(op);
        System.out.println(i);
    }
}
