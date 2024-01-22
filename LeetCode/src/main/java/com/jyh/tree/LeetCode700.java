package com.jyh.tree;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode700 {
    /**
     * 700. 二叉搜索树中的搜索
     * leetcode url : https://leetcode.cn/problems/search-in-a-binary-search-tree/description/
     * 代码随想录 url : https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0700.%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91%E4%B8%AD%E7%9A%84%E6%90%9C%E7%B4%A2.md
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        Integer[] nodeValArray = {4,2,7,1,3};
        TreeNode root = TreeCreator.Create(nodeValArray);
        System.out.println(s1.searchBST(root,2));

    }

    static class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            if(root == null){
                return null;
            }
            if (root.val == val){
                return root;
            }
            if(root.val > val){
                return searchBST(root.left, val);
            }
            if(root.val < val){
                return searchBST(root.right, val);
            }
            return null;
        }
    }
}
