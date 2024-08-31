package com.charlie.leetcode.string;

/**
 * <h1>反转字符串Ⅱ</h1>
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 */
public class Solution541 {

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        String s1 = reverseStr(s, k);
        System.out.println("reversed=" + s1);
    }

    public static String reverseStr(String s, int k) {
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i += 2*k) {
            if (i + k - 1 < c.length - 1) {
                reverse(c, i, i + k - 1);
            } else {
                reverse(c, i, c.length - 1);
            }
        }
        return new String(c);
    }

    public static void reverse(char[] s, int start, int end) {
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }

}
