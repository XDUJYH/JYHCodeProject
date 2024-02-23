package com.jyh.backTracking;

import com.jyh.tree.TreeCreator;
import com.jyh.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode77 {
    /**
     * 77. 组合
     * leetcode url : https://leetcode.cn/problems/combinations/description/
     * 代码随想录 url : https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0077.%E7%BB%84%E5%90%88.md
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        System.out.println(s1.combine(4, 2));

    }

    static class Solution {

        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        public List<List<Integer>> combine(int n, int k) {
            backTracking(n,k,1);
            return result;
        }
        public void backTracking(int n, int k, int startIndex){
            // 终止条件
            if(path.size() == k){
                result.add(new ArrayList<>(path));
                return;
            }
            for(int i = startIndex; i <= n - (k-path.size()) + 1; i ++){
                path.add(i);
                backTracking(n, k, i + 1);
                path.removeLast();
            }
        }
    }
}

