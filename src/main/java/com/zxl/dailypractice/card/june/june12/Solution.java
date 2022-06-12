package com.zxl.dailypractice.card.june.june12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/6/12
 * @Version 1.0
 **/
//查找和替换模式       https://leetcode.cn/problems/find-and-replace-pattern/
public class Solution {
    public List<String> findAndReplacePattern(String[] ws, String pe) {
        List<String> ans = new ArrayList<>();
        int[] map = new int[26], vis = new int[26];
        for (String s : ws) {
            Arrays.fill(map, -1);
            Arrays.fill(vis, 0);
            boolean ok = true;
            for (int i = 0; i < pe.length() && ok; i++) {
                int c1 = s.charAt(i) - 'a', c2 = pe.charAt(i) - 'a';
                if (map[c1] == -1 && vis[c2] == 0) {
                    map[c1] = c2; vis[c2] = 1;
                } else if (map[c1] != c2) {
                    ok = false;
                }
            }
            if (ok) {
                ans.add(s);
            }
        }
        return ans;
    }
}
