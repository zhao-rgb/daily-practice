package com.zxl.dailypractice.card.may.may16;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/5/16
 * @Version 1.0
 **/
//面试题 04.06. 后继者    https://leetcode.cn/problems/successor-lcci/
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        }
        TreeNode ans = inorderSuccessor(root.left, p);
        return ans == null ? root : ans;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
