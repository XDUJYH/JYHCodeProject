package com.jyh.tree;

import java.util.*;

public class LeetCode236 {
    /**
     *
     * 236. 二叉树的最近公共祖先
     * leetcode url : https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/
     * 代码随想录 url : https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0235.%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91%E7%9A%84%E6%9C%80%E8%BF%91%E5%85%AC%E5%85%B1%E7%A5%96%E5%85%88.md
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        Integer[] nodeValArray = {3,5,1,6,2,0,8,null,null,7,4};
        Integer[] p_ = {5};
        Integer[] q_ = {4};
        TreeNode root = TreeCreator.Create(nodeValArray);
        TreeNode p = TreeCreator.Create(p_);
        TreeNode q = TreeCreator.Create(q_);
        System.out.println(s1.lowestCommonAncestor(root, p ,q));

    }

    static class Solution {
        Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
        Set<Integer> visited = new HashSet<Integer>();

        public void dfs(TreeNode root) {
            if (root.left != null) {
                parent.put(root.left.val, root);
                dfs(root.left);
            }
            if (root.right != null) {
                parent.put(root.right.val, root);
                dfs(root.right);
            }
        }

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            dfs(root);
            while (p != null) {
                visited.add(p.val);
                p = parent.get(p.val);
            }
            while (q != null) {
                if (visited.contains(q.val)) {
                    return q;
                }
                q = parent.get(q.val);
            }
            return null;
        }
    }
}
