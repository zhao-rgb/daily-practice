package com.zxl.dailypractice.card.two.September.September2;

/**
 * @author: zhaoxl
 * @date: 2022/9/1
 * @desc:
 **/
//最长同值路径       https://leetcode.cn/problems/longest-univalue-path/
public class Solution {
    int res;

    public int longestUnivaluePath(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = dfs(root.left),right = dfs(root.right);
        int left1 = 0,right1 = 0;
        if (root.left != null && root.left.val == root.val){
            left1 = left + 1;
        }
        if (root.right != null && root.right.val == root.val){
            right1 = right + 1;
        }
        res = Math.max(res,left1+right1);
        return Math.max(left1,right1);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}


