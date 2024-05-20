package com.jyh.DynamicProgramming;


import java.util.*;

public class LeetCode494 {
    /**
     * 494. 目标和
     * leetcode url : https://leetcode.cn/problems/target-sum/description/
     * 代码随想录 url : https://github.com/XDUJYH/leetcode-master/blob/master/problems/0494.%E7%9B%AE%E6%A0%87%E5%92%8C.md
     * 两种方法，回溯和动态规划都写在这个代码里了
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        int[] nums = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int target = 0;
        System.out.println(s1.findTargetSumWays(nums, target));

    }

    static class Solution{
        public int findTargetSumWays(int[] nums, int target) {
            int sum = 0;
            for(int i = 0; i < nums.length; i++){
                sum += nums[i];
            }
            if(target > sum){
                return 0;
            }
            int num = sum - target;
            if(num % 2 != 0){
                return 0;
            }
            int trueTarget = num / 2;
            int n = nums.length;
            int[][] dp = new int[n + 1][trueTarget + 1];
            dp[0][0] = 1;
            for(int i = 1;i <= n ; i++){
                num = nums[i - 1];
                for(int j = 0; j<=trueTarget; j++){
                    dp[i][j] += dp[i-1][j];
                    if(j >= num){
                        dp[i][j] += dp[i-1][j - num];
                    }
                }
            }
            return dp[n][trueTarget];
        }
    }
    static class SolutionBackTracking {
        public LinkedList<Integer> path = new LinkedList<>();
        public LinkedList<LinkedList<Integer>> result = new LinkedList<>();
        public int findTargetSumWays(int[] nums, int target) {
            int sum = 0;
            for(int i = 0; i < nums.length; i++){
                sum += nums[i];
            }

            int num = sum + target;
            if(num % 2 != 0){
                return 0;
            }
            int trueTarget = num / 2;
            Arrays.sort(nums);
            backTracking(nums, trueTarget, 0, 0);
//            System.out.println(result);
            return result.size();
        }
        public void backTracking(int[] nums, int target, int startIndex, int preSum){
            if(preSum == target){
                result.add(path);
            }
            for(int i = startIndex; i < nums.length; i++){
                path.add(nums[i]);
                preSum+=nums[i];
                backTracking(nums, target, i+1, preSum);
                preSum-=nums[i];
                path.removeLast();
            }
        }
    }
}
