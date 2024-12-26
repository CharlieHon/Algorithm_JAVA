package com.charlie.leetcode.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: charlie
 * @CreateTime: Created in 2024/12/26 11:24
 * @Description: 单词拆分
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 *
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 */
public class Solution139 {

    public static boolean wordBeak(String s, List<String> wordDict) {

        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        // 有序
        // 先遍历背包
        for (int i = 1; i <= s.length(); i++) {
            // 在遍历物品
            for (int j = 0; j < i; j++) {
                // out:
                // String word = s.substring(j, i);
                // System.out.println("word=" + word);
                // 递推公式：dp[i] = true if ( s[j:i)在字典中 && dp[j] = true )
                if (wordSet.contains(/* word */s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                }
                // out:
                // System.out.println("dp=" + Arrays.toString(dp));
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> wordDict = List.of("apple", "pen");
        boolean b = wordBeak(s, wordDict);
        System.out.println("wordBeak=" + b);
    }
}
