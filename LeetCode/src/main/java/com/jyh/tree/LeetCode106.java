package com.jyh.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LeetCode106 {
    /**
     * 106. 从中序与后序遍历序列构造二叉树
     * leetcode url : https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
     * 代码随想录 url : https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0106.%E4%BB%8E%E4%B8%AD%E5%BA%8F%E4%B8%8E%E5%90%8E%E5%BA%8F%E9%81%8D%E5%8E%86%E5%BA%8F%E5%88%97%E6%9E%84%E9%80%A0%E4%BA%8C%E5%8F%89%E6%A0%91.md
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        Integer[] nodeValArray = {1,2,3,4,null,5,6,null,null,7};
        TreeNode root = TreeCreator.Create(nodeValArray);
        System.out.println(s1);

    }

    static class Solution {
        private Map<Integer, Integer> indexMap;
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            int n = inorder.length;
            indexMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                indexMap.put(inorder[i], i);
            }

            return myBuildTree(inorder, postorder, 0, n - 1, 0, n - 1);
        }

        public TreeNode myBuildTree(int[] inorder, int[] postorder, int inorderLeft, int inorderRight, int postorderLeft, int postorderRight){
            if (postorderLeft > postorderRight){
                return null;
            }
            int rootVal = postorder[postorderRight];
            TreeNode root = new TreeNode(rootVal);
            int rootIndex = indexMap.get(rootVal);
            int rightTreeNum = inorderRight - rootIndex;

            root.right = myBuildTree(inorder, postorder, rootIndex + 1, inorderRight, postorderRight - rightTreeNum, postorderRight - 1);
            root.left = myBuildTree(inorder, postorder, inorderLeft, rootIndex - 1, postorderLeft, postorderRight - rightTreeNum - 1);

            return root;
        }




    }
}
