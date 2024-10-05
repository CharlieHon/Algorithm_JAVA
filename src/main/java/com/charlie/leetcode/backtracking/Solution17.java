package com.charlie.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>电话号码的字母组合</h3>
 */
public class Solution17 {

    private List<String> res;   // 组合集合
    private StringBuilder sb;   // 每个组合
    // 数字到字符串的映射
    private final String[] num2String = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return res;
        }
        sb = new StringBuilder();
        backtracking(digits, 0);
        return res;
    }

    private void backtracking(String digits, int start) {
        if (start >= digits.length()) {
            res.add(sb.toString());
            return;
        }

        String str = num2String[digits.charAt(start) - '0'];
        // sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            backtracking(digits, start + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
