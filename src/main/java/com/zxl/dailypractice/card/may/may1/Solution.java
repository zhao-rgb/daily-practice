package com.zxl.dailypractice.card.may.may1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/4/30
 * @Version 1.0
 **/
//两棵二叉搜索树中的所有元素         https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees/
public class Solution {
    List<Integer> ans;
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ans = new ArrayList<>();
        dfs(root1);
        dfs(root2);
        Collections.sort(ans);
        return ans;
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        ans.add(root.val);
        dfs(root.right);
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
