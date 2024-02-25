
package com.jyh.backTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode93 {
    /**
     * 93. 复原 IP 地址
     * leetcode url : https://leetcode.cn/problems/restore-ip-addresses/description/
     * 代码随想录 url : https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0093.%E5%A4%8D%E5%8E%9FIP%E5%9C%B0%E5%9D%80.md
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        System.out.println(s1);

    }

    static class Solution {

        List<String> result = new ArrayList<>();
        LinkedList<String> path = new LinkedList<>();

        public List<String> restoreIpAddresses(String s) {
            backTracking(s, 0, 1);
            return result;
        }
        public void backTracking(String s, int startIndex, int depth){
            if(path.size() == 4){
                String res = path.get(0) +'.'+path.get(1) +'.'+path.get(2) +'.'+path.get(3);
                result.add(res);
            }

            for (int i = startIndex; i <= s.length(); i++){
                if (depth == 4){
                    if (isValid(s.substring(startIndex))){
                        path.add(s.substring(startIndex));
                        backTracking(s, i, depth + 1);
                        path.removeLast();
                    }
                    break;
                }
                if (isValid(s.substring(startIndex, i))){
                    path.add(s.substring(startIndex, i));
                    backTracking(s, i, depth + 1);
                    path.removeLast();
                }
            }
        }
        public boolean isValid(String s){
            if (s.length()==0){
                return false;
            }
            int num = 0;
            if (s.charAt(0) == '0' && s.length()!=1) { // 0开头的数字不合法
                return false;
            }
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 遇到⾮数字字符不合法
                    return false;
                }
                num = num * 10 + (s.charAt(i) - '0');
                if (num > 255) { // 如果⼤于255了不合法
                    return false;
                }
            }
            return true;
        }
    }
}

