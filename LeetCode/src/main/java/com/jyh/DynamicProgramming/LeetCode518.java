package com.jyh.DynamicProgramming;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode518 {
    /**
     * 518. 零钱兑换 II
     * leetcode url : https://leetcode.cn/problems/coin-change-ii/description/
     * 代码随想录 url : https://github.com/XDUJYH/leetcode-master/blob/master/problems/0518.%E9%9B%B6%E9%92%B1%E5%85%91%E6%8D%A2II.md
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(s1);

    }

    static class Solution {
        public int change(int amount, int[] coins) {
            int n = coins.length;
            int[] dp = new int[amount + 1];
            dp[0] = 1;
            for(int i = 0; i < n; i ++){
                for(int j = coins[i]; j <= amount; j++){
                    dp[j] += dp[j - coins[i]];
                }
            }
            return dp[amount];
        }
    }
}
