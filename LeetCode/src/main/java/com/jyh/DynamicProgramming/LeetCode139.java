package com.jyh.DynamicProgramming;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode139 {
    /**
     * 139. 单词拆分
     * leetcode url : https://leetcode.cn/problems/word-break/description/
     * 代码随想录 url : https://github.com/XDUJYH/leetcode-master/blob/master/problems/0139.%E5%8D%95%E8%AF%8D%E6%8B%86%E5%88%86.md
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        s1.wordBreak(s,wordDict);

    }

    static class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            int n = s.length();
            boolean[] dp = new boolean[n + 1];
            dp[0] = true;
            for (int i = 1; i <= n; i++){
                for(int j = 0; j < wordDict.size()&& !dp[i]; j++){
                    String str = wordDict.get(j);
                    if(str.length() <= i){
                        dp[i] = dp[i - str.length()]&&wordDict.contains(s.substring(i-str.length(),i));
                    }
                }
            }
//            System.out.println(Arrays.toString(dp));
            return dp[n];
        }
    }
}
