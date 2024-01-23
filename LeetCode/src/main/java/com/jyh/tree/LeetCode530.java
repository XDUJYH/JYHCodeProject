package com.jyh.tree;

public class LeetCode530 {
    /**
     *
     * 530. 二叉搜索树的最小绝对差
     * leetcode url : https://leetcode.cn/problems/minimum-absolute-difference-in-bst/description/
     * 代码随想录 url : https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0530.%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91%E7%9A%84%E6%9C%80%E5%B0%8F%E7%BB%9D%E5%AF%B9%E5%B7%AE.md
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        Integer[] nodeValArray = {4,2,7,1,3};
        TreeNode root = TreeCreator.Create(nodeValArray);
        System.out.println(s1.getMinimumDifference(root));

    }

    static class Solution {
        public int getMinimumDifference(TreeNode root) {

        }
        public void dfs(TreeNode root){

        }
    }
}
