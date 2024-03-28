

package com.jyh.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode90 {
    /**
     * 90. 子集 II
     * leetcode url : https://leetcode.cn/problems/subsets-ii/description/
     * 代码随想录 url : https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0090.%E5%AD%90%E9%9B%86II.md
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
            Arrays.sort(nums);
            backTracking(nums, 0);
            return result;
        }
        //这是回溯模板写法，也就是有for循环的写法
        public void backTracking(int[] nums, int startIndex){
            result.add(new ArrayList<>(path));
            for(int i = startIndex; i < nums.length; i ++){
//                if(i != 0 && nums[i] == nums[i-1]){
//                    continue;
//                }
                if(i  > startIndex && nums[i] == nums[i-1]){
                    continue;
                }
                path.add(nums[i]);
                backTracking(nums, i + 1);
                path.removeLast();
            }
        }
    }
}

