package com.jyh.DynamicProgramming;


import java.util.Arrays;

public class LeetCode300 {
    /**
     * 300. 最长递增子序列
     * leetcode url : https://leetcode.cn/problems/longest-increasing-subsequence/description/
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        System.out.println(s1);

    }

    static class Solution {
        public int lengthOfLIS(int[] nums) {
            if(nums.length == 1){
                return 1;
            }
            int n = nums.length;
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            int max = 1;
            for(int i = 1; i < n; i ++){
                for(int j = 0; j < i; j++){
                    if(nums[i] > nums[j]){
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                    }
                }
                max = Math.max(dp[i], max);
            }

            return max;
        }
    }
}
