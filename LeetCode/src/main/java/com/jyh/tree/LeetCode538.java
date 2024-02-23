package com.jyh.tree;

import java.lang.invoke.VarHandle;

public class LeetCode538 {
    /**
     * 538. 把二叉搜索树转换为累加树
     * leetcode url : https://leetcode.cn/problems/convert-bst-to-greater-tree/description/
     * 代码随想录 url : https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0538.%E6%8A%8A%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91%E8%BD%AC%E6%8D%A2%E4%B8%BA%E7%B4%AF%E5%8A%A0%E6%A0%91.md
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        Integer[] nodeValArray = {10,5,-3,3,2,null,11,3,-2,null,1};
        TreeNode root = TreeCreator.Create(nodeValArray);
        System.out.println(s1);

    }

    static class Solution {
        int sum;
        public TreeNode convertBST(TreeNode root) {
            sum = 0;
            convert(root);
            return root;
        }
        public void convert(TreeNode root){
            if (root == null){
                return ;
            }
            convert(root.right);
            sum += root.val;
            root.val = sum;
            convert(root.left);
        }
    }
}

