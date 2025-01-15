package com.charlie.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/1/15 16:42
 * @Description: 水果成篮（快慢指针）
 */
public class Solution904 {
    public static int totalFruit(int[] fruits) {
        int res = 0;
        int i = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int j = 0; j < fruits.length; j++) {
            map.put(fruits[j], map.getOrDefault(fruits[i], 0) + 1);
            while (map.size() > 2) {
                int fruit = fruits[i];
                if (map.get(fruit) == 1) {
                    map.remove(fruit);
                } else {
                    map.put(fruit, map.get(fruit) - 1);
                }
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }

    public int totalFruit2(int[] fruits) {
        int res = 0;
        // counts[i]表示种类i的水果个数
        int[] counts = new int[fruits.length + 1];
        // [i, j]范围收获水果的类别数，题目要求不能超过2
        int fruitCls = 0;
        for (int i = 0, j = 0; j < fruits.length; j++) {
            // 新增一类水果
            if (++counts[fruits[j]] == 1) {
                fruitCls++;
            }
            while (fruitCls > 2) {
                // 完全舍弃一类水果
                if (--counts[fruits[i++]] == 0) {
                    fruitCls--;
                }
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
