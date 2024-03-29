package com.jyh.backTracking;

import java.lang.annotation.Target;
import java.util.*;

public class LeetCode39 {
    /**
     * 39. 组合总和
     * leetcode url : https://leetcode.cn/problems/combination-sum/description/
     * 代码随想录 url : https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0039.%E7%BB%84%E5%90%88%E6%80%BB%E5%92%8C.md
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(s1.combinationSum(candidates, 7));

    }

    static class Solution {
        int sum = 0;
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            backTracking(target, 0, candidates);
            return result;
        }
        public void backTracking(int target, int startIndex, int[] candidates){
            if (sum == target){
                result.add(new ArrayList<>(path));
                return;
            }
            for (int i = startIndex;(i < candidates.length)&&(sum + candidates[i] <= target); i++ ){
                sum += candidates[i];
                path.add(candidates[i]);
                backTracking(target, i, candidates);
                sum -= candidates[i];
                path.removeLast();
            }
        }
    }
}

