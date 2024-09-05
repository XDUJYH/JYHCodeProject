package com.jyh.DynamicProgramming;


import java.util.Arrays;

public class LeetCode674 {
    /**
     * 674. 最长连续递增序列
     * leetcode url : https://leetcode.cn/problems/longest-continuous-increasing-subsequence/description/
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        System.out.println(s1);

    }

    static class Solution {
        public int findLengthOfLCIS(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            int ans = 0;
            for(int i = 1; i < n; i++){
                if(nums[i] > nums[i - 1]){
                    dp[i] = Math.max(dp[i - 1] + 1, dp[i]);
                }
                ans = Math.max(ans, dp[i]);
            }
            return ans;
        }
    }
}
