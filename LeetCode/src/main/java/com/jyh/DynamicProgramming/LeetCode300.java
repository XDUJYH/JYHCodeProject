package com.jyh.DynamicProgramming;


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
            dp[0] = 1;
            int max = 0;
            for(int i = 1; i < n; i ++){
                if(nums[i] > nums[i - 1]){
                    dp[i] = dp[i - 1] + 1;
                }else{
                    dp[i] = dp[i-1];
                }
                max = Math.max(dp[i], max);
            }
            return max;
        }
    }
}
