package com.jyh.tree;

import java.util.HashMap;
import java.util.Map;

public class LeetCode654 {
    /**
     * 654. 最大二叉树
     * leetcode url : https://leetcode.cn/problems/maximum-binary-tree/
     * 代码随想录 url : https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0654.%E6%9C%80%E5%A4%A7%E4%BA%8C%E5%8F%89%E6%A0%91.md
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        Integer[] nodeValArray = {1,2,3,4,null,5,6,null,null,7};
        TreeNode root = TreeCreator.Create(nodeValArray);
        System.out.println(s1);

    }

    static class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return myConstructMaximumBinaryTree(nums, 0, nums.length - 1);
        }
        public TreeNode myConstructMaximumBinaryTree(int[] nums, int leftIndex, int rightIndex){
            if(leftIndex > rightIndex){
                return null;
            }
            int maxVal = Integer.MIN_VALUE;
            int maxValIndex = -1;

            for(int i = leftIndex; i <= rightIndex; i ++){
                if(nums[i] > maxVal){
                    maxVal = nums[i];
                    maxValIndex = i;
                }
            }
            TreeNode root = new TreeNode(maxVal);
            root.left = myConstructMaximumBinaryTree(nums, leftIndex, maxValIndex - 1);
            root.right = myConstructMaximumBinaryTree(nums, maxValIndex + 1, rightIndex);
            return root;
        }
    }
}
