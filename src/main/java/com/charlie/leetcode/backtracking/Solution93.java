package com.charlie.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>复原IP地址</h3>
 */
public class Solution93 {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }
        StringBuilder sb = new StringBuilder(s);
        backtracking(sb, 0, 0, res);
        return res;
    }

    /**
     * 回溯复原IP地址
     * @param s 字符串
     * @param start 起始位置
     * @param pointNum 字符串中 '.' 字符的个数
     * @param res   可能的IP地址集合
     */
    private void backtracking(StringBuilder s, int start, int pointNum, List<String> res) {
        if (pointNum == 3) {
            // 最后一段是否符合0~255，如 127.0.0.1 中最后一段即1
            if (isValid(s, start, s.length() - 1)) {
                res.add(s.toString());
            }
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (i - start + 1 > 3) {    // 超过3位，结束遍历
                break;
            }
            if (isValid(s, start, i)) { // [start, i] 是否符合0~255
                s.insert(i + 1, '.');    // 符合，则加.分割，如 255.255255255
                backtracking(s, i + 2, pointNum + 1, res);  // 下一次从 i + 2开始，因为多加了个 .
                s.deleteCharAt(i + 1);      // 回溯，删除该 .
            }
        }
    }

    // [start, end]范围内，sb是否符合0~255
    private boolean isValid(StringBuilder sb, int start, int end) {
        if (start > end) {
            return false;
        }
        // 以0开头，并且位数不为1，如00、01等
        if (sb.charAt(start) == '0' && end > start) {
            return false;
        }
        // 大于255，如531、268等
        if (Integer.parseInt(sb.substring(start, end + 1)) > 255) {
            return false;
        }
        return true;
    }

}
