package com.charlie.leetcode.string;

/**
 * <h1>右旋字符串</h1>
 * 字符串的右旋转操作是把字符串尾部的若干个字符转移到字符串的前面。给定一个字符串 s 和一个正整数 k，请编写一个函数，
 * 将字符串中的后面 k 个字符移到字符串的前面，实现字符串的右旋转操作。 </p>
 * 例如，对于输入字符串 "abcdefg" 和整数 2，函数应该将其转换为 "fgabcde"。
 */
public class Kama55 {

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        String s1 = rightXuan(s, k);
        System.out.println("s1=>" + s1 + "<=");
    }

    public static String rightXuan(String s, int k) {
        // edcbagf -> fgabcde
        int len = s.length();
        char[] chars = s.toCharArray();
        reverse(chars, 0, len - k - 1);
        reverse(chars, len - k, len - 1);
        reverse(chars, 0, len - 1);
        return new String(chars);
    }

    public static void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
    }

}
