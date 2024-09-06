package com.jyh.DynamicProgramming;


public class LeetCode392 {
    /**
     * 392. 判断子序列
     * https://leetcode.cn/problems/is-subsequence/description/
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        System.out.println(s1);

    }

    static class Solution {
        public boolean isSubsequence(String s, String t) {
            if (s.length() == 0){
                return true;
            }
            int i = 0;
            int j = 0;
            while (j < t.length()){
                if(s.charAt(i) == t.charAt(j)){
                    i++;
                    j++;
                }else {
                    j++;
                }
                if(i == s.length()){
                    return true;
                }
            }
            return false;
        }
    }
}
