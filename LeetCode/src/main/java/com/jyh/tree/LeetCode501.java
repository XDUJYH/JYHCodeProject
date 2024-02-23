package com.jyh.tree;

import java.util.ArrayList;
import java.util.List;

public class LeetCode501 {
    /**
     *
     * 501.二叉搜索树中的众数
     * leetcode url : https://leetcode.cn/problems/find-mode-in-binary-search-tree/description/
     * 代码随想录 url : https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0501.%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91%E4%B8%AD%E7%9A%84%E4%BC%97%E6%95%B0.md
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        Integer[] nodeValArray = {1,null,2,2};
        TreeNode root = TreeCreator.Create(nodeValArray);
        System.out.println(s1.findMode(root));

    }

    static class Solution {
        List<Integer> answer = new ArrayList<Integer>();
        int base, count, maxCount;

        public int[] findMode(TreeNode root) {
            dfs(root);
            int[] mode = new int[answer.size()];
            for (int i = 0; i < answer.size(); ++i) {
                mode[i] = answer.get(i);
            }
            return mode;
        }

        public void dfs(TreeNode o) {
            if (o == null) {
                return;
            }
            dfs(o.left);
            update(o.val);
            dfs(o.right);
        }

        public void update(int x) {
            if (x == base) {
                ++count;
            } else {
                count = 1;
                base = x;
            }
            if (count == maxCount) {
                answer.add(base);
            }
            if (count > maxCount) {
                maxCount = count;
                answer.clear();
                answer.add(base);
            }
        }
}
}
