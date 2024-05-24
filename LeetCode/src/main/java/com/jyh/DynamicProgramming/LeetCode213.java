package com.jyh.DynamicProgramming;


public class LeetCode213 {
    /**
     * 213. 打家劫舍 II
     * leetcode url : https://leetcode.cn/problems/house-robber-ii/description/
     * 代码随想录 url : https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0213.%E6%89%93%E5%AE%B6%E5%8A%AB%E8%88%8DII.md
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(s1);

    }

    static class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            if(n == 1){
                return nums[0];
            }
            int[] dp1 = new int[n + 1];
            int[] dp2 = new int[n + 1];
            int result = 0;
            dp1[1]=nums[0];
            dp2[1] = 0;
            for(int i = 2;i <= n;i++){
                dp1[i] = Math.max(dp1[i-1],nums[i-1]+dp1[i-2]);
                dp2[i] = Math.max(dp2[i-1],nums[i-1]+dp2[i-2]);
            }
            return Math.max(dp1[n - 1], dp2[n]);
        }
    }
}
