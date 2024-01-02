package com.jyh.tree;

import java.util.HashMap;
import java.util.Map;

public class LeetCode105 {
    /**
     * 105. 从前序与中序遍历序列构造二叉树
     * leetcode url : https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int n = preorder.length;
            // 构造哈希映射，快速定位根节点
            indexMap = new HashMap<Integer, Integer>();
            for (int i = 0; i < n; i++) {
                indexMap.put(inorder[i], i);
            }
            return myBuildTree(preorder, inorder, 0, n - 1, 0, n-1);
        }
        //递归函数
        public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight){
            if(preorderLeft > preorderRight){
                return null;
            }

            TreeNode root = new TreeNode(preorder[preorderLeft]);
            int inorderRootIndex = indexMap.get(preorder[preorderLeft]);
            int leftTreeNum = inorderRootIndex - inorderLeft;
            root.left = myBuildTree(preorder, inorder, preorderLeft + 1, preorderLeft + leftTreeNum, inorderLeft, inorderRootIndex - 1);
            root.right = myBuildTree(preorder, inorder, preorderLeft + 1 + leftTreeNum, preorderRight, inorderRootIndex + 1, inorderRight);
            return root;
        }

    }
}
