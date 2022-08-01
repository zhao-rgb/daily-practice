package com.zxl.dailypractice.card.two.december.December5;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2021/12/4
 * @Version 1.0
 **/
//超级次方    https://leetcode-cn.com/problems/super-pow/solution/java-kuai-su-mi-si-lu-qing-xi-dai-ma-jia-slw6/
//      https://www.bilibili.com/video/BV1bX4y1G77Z?p=2&spm_id_from=pageDriver
//  不是很懂！！！
public class Solution {
    int base = 1337;
    public int superPow(int a, int[] b) {
        Deque<Integer> queue = new ArrayDeque<>();
        for (int num : b) {
            queue.addLast(num);
        }
        return superPow(a,queue);
    }

    private int superPow(int a, Deque<Integer> queue) {
        if (queue.isEmpty()){
            return 1;
        }
        int lastBit = queue.removeLast();
        int part1 = myPow(a,lastBit);
        int part2 = myPow(superPow(a,queue),10);
        return (part1*part2)%base;
    }

    // (a * b) % k = [(a % k) * (b % k)] % k
    /*
        assume 这个函数 已经 返回 mod k 的结果
    */
    private int myPow(int a, int b){
        if(b == 0){
            return 1;
        }
        if (b%2==0){
            return myPow(((a % base) * (a % base)) % base,b/2);
        } else {
            return ((a%base) * myPow(a,b-1)%base);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int a = 2147483647;
        int[] b = {2,0,0};
        int i = solution.superPow(a, b);
        System.out.println(i);
    }
}
