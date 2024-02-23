package com.jyh.backTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode216 {
    /**
     * 216. 组合总和 III
     * leetcode url : https://leetcode.cn/problems/combination-sum-iii/description/
     * 代码随想录 url : https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0216.%E7%BB%84%E5%90%88%E6%80%BB%E5%92%8CIII.md
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        System.out.println(s1.combinationSum3(4, 2));

    }

    static class Solution {

        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        public List<List<Integer>> combinationSum3(int k, int n) {
            backTracking(k,n,1, 0);
            return result;
        }
        public void backTracking(int k, int n, int startIndex, int sum){
            // 终止条件
            if(path.size() == k){
                if (sum == n){
                    result.add(new ArrayList<>(path));
                }
                return;
            }
            for(int i = startIndex; i <= 9 - (k - path.size()) + 1; i ++){
                path.add(i);
                sum += i;
                backTracking(k, n, i + 1, sum);
                sum -= i;
                path.removeLast();
            }
        }
    }
}

