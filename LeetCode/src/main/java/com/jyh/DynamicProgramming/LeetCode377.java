package com.jyh.DynamicProgramming;


public class LeetCode377 {
    /**
     * 377. 组合总和 Ⅳ
     * leetcode url : https://leetcode.cn/problems/combination-sum-iv/description/
     * 代码随想录 url : https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0377.%E7%BB%84%E5%90%88%E6%80%BB%E5%92%8C%E2%85%A3.md
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(s1);

    }

    static class Solution {
        public int combinationSum4(int[] nums, int target) {
            int n = nums.length;
            int[] dp = new int[target + 1];
            dp[0] = 1;
            for(int j = 1; j <= target; j++){
                for(int i = 0; i < n; i++){
                    if(j >= nums[i]){
                        dp[j] += dp[j-nums[i]];
                    }
                }
            }

//            for(int i = 0; i < n; i++){
//                for(int j = nums[i]; j <= target; j++){
//                    dp[j] += dp[j - nums[i]];
//                }
//            }

            return dp[target];
        }
    }
}
