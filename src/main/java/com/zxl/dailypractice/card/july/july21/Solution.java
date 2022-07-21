package com.zxl.dailypractice.card.july.july21;

/**
 * @author: zhaoxl
 * @date: 2022/7/21
 * @desc:
 **/
//二叉树剪枝  https://leetcode.cn/problems/binary-tree-pruning/
public class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null){
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
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
