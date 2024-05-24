package com.jyh.DynamicProgramming;


public class LeetCode198 {
    /**
     * 198. 打家劫舍
     * leetcode url : https://leetcode.cn/problems/house-robber/description/
     * 代码随想录 url : https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0198.%E6%89%93%E5%AE%B6%E5%8A%AB%E8%88%8D.md
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(s1);

    }

    static class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n+1];
            dp[1]=nums[0];
            for(int i = 2;i <= n;i++){
                dp[i] = Math.max(dp[i-1],nums[i-1]+dp[i-2]);
            }
            return dp[n];
        }
    }
}
