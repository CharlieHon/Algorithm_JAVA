package com.charlie.leetcode.hashtable;

import java.util.*;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/1/18 14:28
 * @Description: 字母异位词分组
 * 思路：对于异位词如 aab aba baa，字母排序后结果为相同的单词，即 aab。因此可以使用排序后的字符串作为key，异位词作为value记录
 */
public class Solution49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> record = new HashMap<>();
        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            // if (record.containsKey(new String(ch))) {
            //     record.get(new String(ch)).add(str);
            // } else {
            //     List<String> temp = new ArrayList<>();
            //     temp.add(str);
            //     record.put(new String(ch), temp);
            // }

            record.computeIfAbsent(new String(ch), k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(record.values());
    }

}
