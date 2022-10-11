package com.zxl.dailypractice.card.two.october.october11;

/**
 * @author: zhaoxl
 * @date: 2022/10/11
 * @desc:
 **/
//仅执行一次字符串交换能否使两个字符串相等      https://leetcode.cn/problems/check-if-one-string-swap-can-make-strings-equal/
public class Solution {
    public static void main(String[] args) {
//        Student zxl = new Student("1", "zxl");
//        Student zxl2 = new Student("2", "zxl2");
//        Student zxl3 = new Student("3", "zxl3");
//        Student zxl4 = new Student("4", "zxl4");
//        List<Student> list = new ArrayList<>();
//        list.add(zxl);
//        list.add(zxl2);
//        list.add(zxl3);
//        list.add(zxl4);
//        List<Student> collect = list.stream().filter(p -> "2".equals(p.id)).collect(Collectors.toList());
//        System.out.println(collect);
//        List<Student> collect1 = list.stream().parallel().collect(Collectors.toList());
//        System.out.println(collect1);
        Solution solution = new Solution();
        boolean b = solution.areAlmostEqual("bank", "kand");
        System.out.println(b);
    }

    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length(), a = -1, b = -1;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                continue;
            }
            if (a == -1) {
                a = i;
            } else if (b == -1) {
                b = i;
            } else {
                return false;
            }
        }
        if (a == -1) {
            return true;
        }
        if (b == -1) {
            return false;
        }
        return s1.charAt(a) == s2.charAt(b) && s1.charAt(b) == s2.charAt(a);
    }
}
