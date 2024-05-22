package com.jyh.DynamicProgramming;


public class LeetCode279 {
    /**
     * 279. 完全平方数
     * leetcode url : https://leetcode.cn/problems/perfect-squares/description/
     * 代码随想录 url : https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0279.%E5%AE%8C%E5%85%A8%E5%B9%B3%E6%96%B9%E6%95%B0.md
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(s1);

    }

    static class Solution {
        public int numSquares(int n) {
            int minNum = (int)Math.ceil(Math.sqrt(n));
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            for(int i = 2; i <= n; i++){
                dp[i] = Integer.MAX_VALUE;
                for(int j = 1; j <= minNum; j++){
                    int square = j*j;
                    if(i >= square){
                        dp[i] = Math.min(dp[i], dp[i - square] + 1);
                    }
                }
            }
            return dp[n];
        }
    }
}
