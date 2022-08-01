package com.zxl.dailypractice.card.two.april.april8;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/4/8
 * @Version 1.0
 **/
//N 叉树的层序遍历   https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null){
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int cnt = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                Node cur = queue.poll();
                level.add(cur.val);
                for (Node child : cur.children){
                    queue.offer(child);
                }
            }
            ans.add(level);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
