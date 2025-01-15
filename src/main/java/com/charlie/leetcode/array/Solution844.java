package com.charlie.leetcode.array;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/1/15 13:59
 * @Description: 比较含有退格的字符串
 */
public class Solution844 {

    // 因为回退符#，只会删除其前面的字符，所以可以从后往前比较
    public boolean backSpaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        // 表示需要跳过的次数
        int skipS = 0, skipT = 0;
        while (0 <= i && 0 <= j) {
            // 处理s
            while (0 <= i) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            // 处理t
            while (0 <= j) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }

            // 表示遇到需要比较的字符
            if (0 <= i && 0 <= j) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            } else if (0 <= i || 0 <= j) {  // 表示已经有一个到尽头，但是另一个还没有
                return false;
            }

            i--;
            j--;
        }
        return true;
    }

    // 拼接字符串法
    public static boolean backSpaceCompare3(String s, String t) {
        String s1 = backSpace(s);
        String s2 = backSpace(t);
        return s1.equals(s2);
    }

    private static String backSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!sb.isEmpty() && s.charAt(i) == '#') {
                sb.deleteCharAt(sb.length() - 1);
            } else if (s.charAt(i) != '#') {    // 如果不是#，则添加到sb中
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }



}
