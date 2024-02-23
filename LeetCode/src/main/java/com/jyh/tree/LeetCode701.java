package com.jyh.tree;

public class LeetCode701 {
    /**
     * 701. 二叉搜索树中的插入操作
     * leetcode url : https://leetcode.cn/problems/insert-into-a-binary-search-tree/description/
     * 代码随想录 url : https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0701.%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91%E4%B8%AD%E7%9A%84%E6%8F%92%E5%85%A5%E6%93%8D%E4%BD%9C.md
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        Integer[] nodeValArray = {10,5,-3,3,2,null,11,3,-2,null,1};
        int targetSum = 8;
        TreeNode root = TreeCreator.Create(nodeValArray);
        System.out.println(s1.insertIntoBST(root, targetSum));

    }

    static class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }
            TreeNode rootCopy = root;
            while (rootCopy != null){
                if(val < rootCopy.val){
                    if(rootCopy.left == null){
                        rootCopy.left = new TreeNode(val);
                        break;//之前忘加这个了，导致无限循环
                    }else {
                        rootCopy = rootCopy.left;
                    }
                }else {
                        if(rootCopy.right == null){
                            rootCopy.right = new TreeNode(val);
                            break;//之前忘加这个了，导致无限循环
                        }else {
                            rootCopy = rootCopy.right;
                        }

                }
            }
            return root;
    }
}
}

