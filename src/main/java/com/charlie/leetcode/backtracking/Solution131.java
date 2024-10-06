package com.charlie.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>分割回文串</h3>
 */
public class Solution131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s.length() == 1) {
            res.add(List.of(s));
            return res;
        }
        List<String> path = new ArrayList<>();
        backtracking(s, 0, new StringBuilder(), res, path);
        return res;
    }

    private void backtracking(String s, int start, StringBuilder sb, List<List<String>> res, List<String> path) {
        if (start >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (isPartition(sb)) {
                path.add(sb.toString());
                backtracking(s, i + 1, new StringBuilder(), res, path);
                path.remove(path.size() - 1);
            } else {
                continue;
            }
        }
    }

    private boolean isPartition(StringBuilder sb) {
        if (sb.length() == 1) {
            return true;
        }
        for (int i = 0, j = sb.length() - 1; i < j; i++, j--) {
            if (sb.charAt(i) != sb.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
