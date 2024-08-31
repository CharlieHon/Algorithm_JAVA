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
        String s = "the sky is blue ";
        StringBuffer sb1 = removeSpace(s);
        System.out.println("sb1=>" + sb1 + "<=");
        String s2 = reverseWords(s);
        System.out.println("s2=>" + s2 + "<=");
    }

    public static String reverseWords(String s) {
        StringBuffer sb = removeSpace(s);
        int start = 0;
        for (int j = 0; j < sb.length(); j++) {
            char c = sb.charAt(j);
            if (Character.isSpaceChar(c)) {
                reverseWords(sb, start, j - 1);
                start = j + 1;
            } else if (j == sb.length() - 1) {
                reverseWords(sb, start, j);
            }
        }
        reverseWords(sb, 0, sb.length() - 1);
        return sb.toString();
    }

    // 去除多余空格
    public static StringBuffer removeSpace(String s) {
        // 去除两端空格
        int start, end;
        for (start = 0; start < s.length() - 1; start++) {
            if (!Character.isSpaceChar(s.charAt(start))) {
                break;
            }
        }
        for (end = s.length() - 1; end >= 0; end--) {
            if (!Character.isSpaceChar(s.charAt(end))) {
                break;
            }
        }

        StringBuffer sb = new StringBuffer();
        // 去除中间的空格
        for (int i = start; i <= end; i++) {
            if (!Character.isSpaceChar(s.charAt(i)) || (Character.isSpaceChar(s.charAt(i)) && !Character.isSpaceChar(s.charAt(i-1)))) {
                sb.append(s.charAt(i));
            }
        }

        return sb;
    }

    // 反转指定区间的单词
    public static void reverseWords(StringBuffer sb, int start, int end) {
        while (start < end) {
            char c = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, c);
            start++;
            end--;
        }
    }
}
