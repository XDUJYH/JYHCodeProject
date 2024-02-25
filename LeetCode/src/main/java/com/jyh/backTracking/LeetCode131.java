package com.jyh.backTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode131 {
    /**
     * 131. 分割回文串
     * leetcode url : https://leetcode.cn/problems/palindrome-partitioning/description/
     * 代码随想录 url : https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0131.%E5%88%86%E5%89%B2%E5%9B%9E%E6%96%87%E4%B8%B2.md
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        System.out.println(s1);

    }

    static class Solution {

        List<List<String>> result = new ArrayList<>();
        LinkedList<String> path = new LinkedList<>();
        int pathLength = 0;
        public List<List<String>> partition(String s) {
            backTracking(s, s.length());
            return result;
        }
        public void backTracking(String s, int length){
            if(pathLength == length){
                result.add(new ArrayList<>(path));
            }

            for (int i = 1; i <= s.length(); i ++){
                if (isCircle(s.substring(0,i))){
                    path.add(s.substring(0,i));
                    pathLength += s.substring(0,i).length();
                }else {
                    continue;
                }
                backTracking(s.substring(i), length);
                path.removeLast();
                pathLength -= s.substring(0,i).length();
            }
        }
        public boolean isCircle(String s){
            int i = 0;
            int j = s.length() - 1;
            while (i < j){
                if(s.charAt(i) != s.charAt(j)){
                    return false;
                }
                i ++;
                j --;
            }
            return true;
        }
    }
}

