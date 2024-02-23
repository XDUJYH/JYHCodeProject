package com.jyh.tree;

public class LeetCode108 {
    /**
     * 108. 将有序数组转换为二叉搜索树
     * leetcode url : https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description/
     * 代码随想录 url : https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0108.%E5%B0%86%E6%9C%89%E5%BA%8F%E6%95%B0%E7%BB%84%E8%BD%AC%E6%8D%A2%E4%B8%BA%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91.md
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        Integer[] nodeValArray = {10,5,-3,3,2,null,11,3,-2,null,1};
        TreeNode root = TreeCreator.Create(nodeValArray);
        System.out.println(s1);

    }

    static class Solution {

        public TreeNode sortedArrayToBST(int[] nums) {
            return ArrayToBST(nums, 0, nums.length - 1);
        }
        public TreeNode ArrayToBST(int[] nums,int left,int right) {
            if(right < left){
                return null;
            }
            int index = (right + left)/2;
            TreeNode root = new TreeNode(nums[index]);
            if((right - left + 1) >= 2){
                root.left = ArrayToBST(nums, left, index - 1);
                root.right = ArrayToBST(nums, index + 1, right);
            }
            return root;
        }
    }
}

