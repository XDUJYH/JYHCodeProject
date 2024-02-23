package com.jyh.tree;

import java.security.spec.RSAOtherPrimeInfo;

public class LeetCode450 {
    /**
     * 450. 删除二叉搜索树中的节点
     * leetcode url : https://leetcode.cn/problems/delete-node-in-a-bst/description/
     * 代码随想录 url : https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0450.%E5%88%A0%E9%99%A4%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91%E4%B8%AD%E7%9A%84%E8%8A%82%E7%82%B9.md
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        Integer[] nodeValArray = {10,5,-3,3,2,null,11,3,-2,null,1};
        int targetSum = 8;
        TreeNode root = TreeCreator.Create(nodeValArray);
        System.out.println(s1.deleteNode(root, targetSum));

    }

    static class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {

            if (root == null){
                return root;
            }
            if (root.val == key){
                if (root.left == null){
                    return root.right;
                }else if (root.right == null){
                    return root.left;
                }else {
                    TreeNode node = root.right;
                    while (node.left != null){
                        node = node.left;
                    }
                    node.left = root.left;
                    root = root.right;
                    return root;
                }

            }
            if(key < root.val){
                root.left = deleteNode(root.left, key);
            }
            if (key > root.val){
                root.right = deleteNode(root.right, key);
            }
            return root;
        }

    }
}

