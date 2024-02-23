package com.jyh.backTracking;

import java.util.*;

public class LeetCode17 {
    /**
     * 17. 电话号码的字母组合
     * leetcode url : https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/
     * 代码随想录 url : https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0017.%E7%94%B5%E8%AF%9D%E5%8F%B7%E7%A0%81%E7%9A%84%E5%AD%97%E6%AF%8D%E7%BB%84%E5%90%88.md
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        System.out.println(s1);

    }

    static class Solution {
        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        public List<String> letterCombinations(String digits) {
            if (digits.length() == 0) {
                return result;
            }
            StringBuilder stringBuffer = new StringBuilder(digits);
            backTracking(stringBuffer, 0);
            return result;
        }
        public void backTracking(StringBuilder digits, int index){
            if(index == digits.length()){
                result.add(path.toString());
                return;
            }


            String str = phoneMap.get(digits.charAt(index));
            for(int i = 0; i < str.length(); i++){
                path.append(str.charAt(i));
                backTracking(digits, index + 1);
                path.deleteCharAt(path.length() - 1);
            }

        }
    }
}

