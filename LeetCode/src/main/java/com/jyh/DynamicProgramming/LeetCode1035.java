package com.jyh.DynamicProgramming;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode1035 {
    /**
     * 1035. 不相交的线
     * https://leetcode.cn/problems/uncrossed-lines/description/
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        System.out.println(s1);

    }

    static class Solution {
        public int maxUncrossedLines(int[] nums1, int[] nums2) {
            int[][] dp = new int[nums1.length + 1][nums2.length + 1];
            for(int i = 1; i < nums1.length + 1; i++){
                for(int j = 1; j < nums2.length + 1; j++){
                    if(nums1[i - 1] == nums2[j - 1]){
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }else{
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    }
                }
            }
            return dp[nums1.length][nums2.length];
        }
    }
}
