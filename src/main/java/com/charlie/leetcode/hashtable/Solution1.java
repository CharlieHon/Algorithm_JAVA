package com.charlie.leetcode.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <h1>两数之和</h1>
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 * 你可以按任意顺序返回答案
 */
public class Solution1 {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int[] res = twoSum(arr, 9);
        System.out.println("res=" + Arrays.toString(res));
    }

    // 思路：map中记录(值，下标)，然后遍历数组寻找(target - 当前值)
    public static int[] twoSum(int[] nums, int target) {
        // 值 -> 下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int index1 = map.get(target - nums[i]);
                return new int[] {index1, i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

}
