package com.charlie.leetcode.string;

/**
 * <h1>替换数字</h1>
 * 给定一个字符串 s，它包含小写字母和数字字符，请编写一个函数，将字符串中的字母字符保持不变，而将每个数字字符替换为number。
 * 例如，对于输入字符串 "a1b2c3"，函数应该将其转换为 "anumberbnumbercnumber"。
 */
public class Kama54 {
    public static void main(String[] args) {
        String s = "a1bc";
        String s1 = replaceNumber(s);
        System.out.println("s1=" + s1);
    }

    public static String replaceNumber(String s) {
        int cnt = s.length();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('0' <= c && c <= '9') {
                cnt += 5;
            }
        }

        char[] sChar = new char[cnt];
        System.arraycopy(s.toCharArray(), 0, sChar, 0, s.length());
        int i = s.length() - 1;
        int j = cnt - 1;
        while (i < j) {
            char c = s.charAt(i);
            if ('0' <= c && c <= '9') {
                sChar[j--] = 'r';
                sChar[j--] = 'e';
                sChar[j--] = 'b';
                sChar[j--] = 'm';
                sChar[j--] = 'u';
                sChar[j--] = 'n';
            } else {
                sChar[j--] = c;
            }
            i--;
        }
        return new String(sChar);
    }

}
