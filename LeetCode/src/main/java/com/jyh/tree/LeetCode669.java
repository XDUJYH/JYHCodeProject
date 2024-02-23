package com.jyh.tree;

public class LeetCode669 {
    /**
     * 669. 修剪二叉搜索树
     * leetcode url : https://leetcode.cn/problems/trim-a-binary-search-tree/description/
     * 代码随想录 url : https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0669.%E4%BF%AE%E5%89%AA%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91.md
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        Integer[] nodeValArray = {10,5,-3,3,2,null,11,3,-2,null,1};
        int low = 8;
        int high = 10;
        TreeNode root = TreeCreator.Create(nodeValArray);
        System.out.println(s1.trimBST(root, low, high));

    }

    static class Solution {
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if (root == null){
                return root;
            }
            if (root.val < low){
                TreeNode right = trimBST(root.right, low, high);
                return right;
            }
            if (root.val > high){
                TreeNode left = trimBST(root.left, low, high);
                return left;
            }
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }
    }
}

