package com.jyh.DynamicProgramming;


public class LeetCode322 {
    /**
     * 322. 零钱兑换
     * leetcode url : https://leetcode.cn/problems/coin-change/
     * 代码随想录 url : https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0322.%E9%9B%B6%E9%92%B1%E5%85%91%E6%8D%A2.md
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(s1.change(amount, coins));

    }

    static class Solution {
        public int change(int amount, int[] coins) {
            int n = coins.length;
            int[] dp = new int[amount + 1];
            dp[0] = 0;
            for(int i = 1; i <= amount; i++){
                dp[i] = Integer.MAX_VALUE;
            }
            for(int i = 0; i < n; i ++){
                for(int j = coins[i]; j <= amount; j++){
                    if(dp[j-coins[i]] != Integer.MAX_VALUE){
                        dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
                    }
                }
            }
            return dp[amount] == Integer.MAX_VALUE ? -1:dp[amount];
        }
    }
}
