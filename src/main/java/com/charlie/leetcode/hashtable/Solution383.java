package com.charlie.leetcode.hashtable;

/**
 * <h1>赎金信</h1>
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次
 * <p>ransomNote 和 magazine 由小写英文字母组成</p>
 */
public class Solution383 {

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        boolean res = canConstruct(ransomNote, magazine);
        System.out.println("res=" + res);
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        char[] records = new char[26];
        for (int i = 0; i < magazine.length(); i++) {
            records[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (records[ransomNote.charAt(i) - 'a'] == 0) {
                return false;
            } else {
                records[ransomNote.charAt(i) - 'a']--;
            }
        }
        return true;
    }

}
