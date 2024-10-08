package com.jyh.DynamicProgramming;


public class LeetCode1143 {
    /**
     * 1143. 最长公共子序列
     * leetcode url : https://leetcode.cn/problems/longest-common-subsequence/description/
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        System.out.println(s1);

    }

    static class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int[][] dp = new int[text1.length() + 1][text2.length() + 1];
            int ans = 0;
            for (int i = 1; i < text1.length() + 1; i++) {
                for(int j = 1; j < text2.length() + 1; j++){
                    if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                    ans = Math.max(dp[i][j], ans);
                }
            }
            return ans;
        }
    }
}
