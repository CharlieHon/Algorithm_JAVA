package com.charlie.leetcode.string;

/**
 * <h1>翻转字符串里的单词</h1>
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，
 * 单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 */
public class Solution151 {

    public static void main(String[] args) {
        String s = " a cute   dog";
        String reversed = reverseWords(s);
        System.out.println("reversed=>" + reversed + "<=");
    }

    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        // 1. 去除多余空格
        chars = removeSpace(chars);
        // 2. 反转整个字符串
        reverse(chars, 0, chars.length - 1);
        // 3. 反转每个单词
        int start = 0;
        for (int end = 0; end <= chars.length; end++) {
            if (end == chars.length || chars[end] == ' ') {
                reverse(chars, start, end - 1);
                start = end + 1;
            }
        }
        return new String(chars);
    }

    // 使用快慢指针移除多余空格
    public static char[] removeSpace(char[] chars) {
        int slow = 0;
        for (int fast = 0; fast < chars.length; fast++) {
            // 使用fast移除所有空格
            if (chars[fast] != ' ') {
                // 单词之间的空格，除了第一个单词外，单词末尾要加空格
                if (slow != 0) {
                    chars[slow++] = ' ';
                }
                // fast遇到空格或遍历到字符串末尾，就证明遍历完一个单词
                while (fast < chars.length && chars[fast] != ' ') {
                    chars[slow++] = chars[fast++];
                }
            }
        }

        char[] newChars = new char[slow];
        System.arraycopy(chars, 0, newChars, 0, slow);
        return newChars;
    }

    // 双指针实现指定范围内字符串反转
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
