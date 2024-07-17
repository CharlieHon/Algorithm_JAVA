package com.charlie.leetcode.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * <h1>两个数组的交集</h1>
 * 给定两个数组 nums1 和 nums2 ，返回它们的交集。输出结果中的每个元素一定是 唯一 的。可以不考虑输出结果的顺序。
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 */
public class Solution349 {

    /**
     * <h3>死劲儿版</h3>
     * 这里使用数组做哈希表，是因为题目限制了数值的大小。如果题目中没有限制数值大小，就无法使用数组做哈希表
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 数组相交元素
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        int[] h1 = new int[1001];
        int[] h2 = new int[1001];
        int[] tmp = new int[1001];
        int count = 0;
        for (int val1 : nums1) {
            h1[val1]--;
        }
        for (int val2 : nums2) {
            h2[val2]++;
        }

        for (int i = 0; i < 1001; i++) {
            if (h1[i] != 0 && h2[i] != 0) {
                tmp[count++] = i;
            }
        }
        int[] res = new int[count];
        System.arraycopy(tmp, 0, res, 0, count);
        return res;
    }

    /**
     * <h3>使用HashSet</h3>
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 数组相交元素
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> resSet = new HashSet<Integer>();

        // 遍历数组1
        for (int val1 : nums1) {
            set1.add(val1);
        }
        // 遍历数组2，判断哈希表中是否存在该元素
        for (int val2 : nums2) {
            if (set1.contains(val2)) {
                resSet.add(val2);
            }
        }

        // 方法1：将结果集合转为数组
        //return resSet.stream().mapToInt(x -> x).toArray();

        // 方法2：
        int[] res = new int[resSet.size()];
        int index = 0;
        for (int val : resSet) {
            res[index++] = val;
        }
        return res;
    }

}
