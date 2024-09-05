package com.jyh.DynamicProgramming;


import java.util.Arrays;

public class LeetCode718 {
    /**
     * 718. 最长重复子数组
     * leetcode url : https://leetcode.cn/problems/maximum-length-of-repeated-subarray/description/
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        System.out.println(s1);

    }

    static class Solution {
        public int findLength(int[] nums1, int[] nums2) {
            int[][] dp = new int[nums1.length + 1][nums2.length + 1];
            int ans = 0;
            for(int i = 1; i <= nums1.length; i++){
                for(int j = 1; j <= nums2.length; j++){
                    dp[i][j] = nums1[i - 1] == nums2[j - 1] ? dp[i - 1][j - 1] + 1 : 0;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
            return ans;
        }
    }
}
