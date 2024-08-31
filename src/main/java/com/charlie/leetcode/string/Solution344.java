package com.charlie.leetcode.string;

import java.util.Arrays;

/**
 * <h1>反转字符串</h1>
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 */
public class Solution344 {
    public static void main(String[] args) {
        char[] c = {'h', 'e', 'l', 'l', 'o'};
        System.out.println("origin=" + Arrays.toString(c));
        reverseString(c);
        System.out.println("reversed=" + Arrays.toString(c));
    }

    // 双指针法
    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            right--;
            left++;
        }
    }

}
