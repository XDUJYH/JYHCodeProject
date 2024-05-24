package com.jyh.DynamicProgramming;


import com.jyh.tree.TreeNode;

public class LeetCode337 {
    /**
     * 337. 打家劫舍 III
     * leetcode url : https://leetcode.cn/problems/house-robber-iii/description/
     * 代码随想录 url : https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0337.%E6%89%93%E5%AE%B6%E5%8A%AB%E8%88%8DIII.md
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(s1);

    }

    static class Solution {
        public int rob(TreeNode root) {
            return Math.max(dp1(root), dp2(root));
        }
        public int dp1(TreeNode root){
            if(root == null){
                return 0;
            }
            return dp2(root.left) + dp2(root.right) + root.val;
        }
        public int dp2(TreeNode root){
            if(root == null){
                return 0;
            }
            return Math.max(dp1(root.left), dp2(root.left)) + Math.max(dp1(root.right), dp2(root.right));
        }
    }
}
