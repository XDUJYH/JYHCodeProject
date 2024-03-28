
package com.jyh.backTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode78 {
    /**
     * 77. 组合
     * leetcode url : https://leetcode.cn/problems/subsets/description/
     * 代码随想录 url : https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0078.%E5%AD%90%E9%9B%86.md
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        System.out.println(s1);

    }

    static class Solution {

        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        public List<List<Integer>> subsets(int[] nums) {
            backTracking(nums, 0);
            return result;
        }
        //这是选与不选的递归
        public void backTracking(int[] nums, int startIndex){

            if (startIndex == nums.length){
                result.add(new ArrayList<>(path));
                return;
            }
            backTracking(nums, startIndex + 1);
            path.add(nums[startIndex]);

            backTracking(nums, startIndex + 1);
            path.removeLast();
        }
        //这是回溯模板写法，也就是有for循环的写法
        public void backTracking2(int[] nums, int startIndex){
            result.add(new ArrayList<>(path));
            for(int i = startIndex; i < nums.length; i ++){
                path.add(nums[i]);
                backTracking(nums, i + 1);
                path.removeLast();
            }
        }
    }
}

