package com.charlie.leetcode.hashtable;

/**
 * <h1>有效的字母异位词</h1>
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词
 */
public class Solution242 {

    /**
     * <h3>哈希法</h3>
     * 定义一个数组记录字符串s和t中字符出现的次数，当两者是字母异位词时，最终记录数组中的值(即字符出现的次数)均为0
     *
     * @param s 字符串s
     * @param t 字符串t
     * @return 字符串s和t是否互为字母异位词
     */
    public boolean isAnagram(String s, String t) {
        // 如果字符串长度不同，则肯定不是异位词
        if (s.length() != t.length()) {
            return false;
        }

        int[] hashTable = new int[26];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            hashTable[s.charAt(i) - 'a']++;
            hashTable[t.charAt(i) - 'a']--;
        }

        for (int count : hashTable) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
