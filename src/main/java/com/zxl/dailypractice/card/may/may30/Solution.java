package com.zxl.dailypractice.card.may.may30;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/5/30
 * @Version 1.0
 **/
//从根到叶的二进制数之和       https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers/
public class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        val = (val << 1) | root.val;
        if (root.left == null && root.right == null) {
            return val;
        }
        return dfs(root.left, val) + dfs(root.right, val);
    }

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
