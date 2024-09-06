package com.jyh.DynamicProgramming;


public class LeetCode53 {
    /**
     * 53. 最大子数组和
     * https://leetcode.cn/problems/maximum-subarray/description/
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        System.out.println(s1);

    }

    static class Solution {
        public int maxSubArray(int[] nums) {
            int dp = nums[0];
            int ans = nums[0];
            for(int i = 1; i < nums.length; i++){
                dp = Math.max(dp + nums[i], nums[i]);
                ans = Math.max(dp, ans);
            }
            return ans;
        }
    }
}
