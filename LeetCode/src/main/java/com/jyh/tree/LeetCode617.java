package com.jyh.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode617 {
    /**
     * 617. 合并二叉树
     * leetcode url : https://leetcode.cn/problems/merge-two-binary-trees/description/
     * 代码随想录 url : https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0617.%E5%90%88%E5%B9%B6%E4%BA%8C%E5%8F%89%E6%A0%91.md
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        Integer[] nodeValArray = {3,9,20,null,null,15,7};
        TreeNode root = TreeCreator.Create(nodeValArray);
        System.out.println(s1);

    }

    static class Solution {
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if(root1 == null){
                return root2;
            }
            if(root2 == null){
                return root1;
            }
            Deque<TreeNode> queue1 = new LinkedList<>();
            Deque<TreeNode> queue2 = new LinkedList<>();
            Deque<TreeNode> queue = new LinkedList<>();
            TreeNode ansRoot = new TreeNode(root1.val + root2.val);
            queue1.offer(root1);
            queue2.offer(root2);
            queue.offer(ansRoot);

            while (!queue1.isEmpty() && !queue2.isEmpty()) {
                TreeNode node = queue.poll(), node1 = queue1.poll(), node2 = queue2.poll();
                TreeNode left1 = node1.left, left2 = node2.left, right1 = node1.right, right2 = node2.right;
                if (left1 != null || left2 != null) {
                    if (left1 != null && left2 != null) {
                        TreeNode left = new TreeNode(left1.val + left2.val);
                        node.left = left;
                        queue.offer(left);
                        queue1.offer(left1);
                        queue2.offer(left2);
                    } else if (left1 != null) {
                        node.left = left1;
                    } else if (left2 != null) {
                        node.left = left2;
                    }
                }
                if (right1 != null || right2 != null) {
                    if (right1 != null && right2 != null) {
                        TreeNode right = new TreeNode(right1.val + right2.val);
                        node.right = right;
                        queue.offer(right);
                        queue1.offer(right1);
                        queue2.offer(right2);
                    } else if (right1 != null) {
                        node.right = right1;
                    } else {
                        node.right = right2;
                    }
                }

            }
            return ansRoot;
        }

    }
}
