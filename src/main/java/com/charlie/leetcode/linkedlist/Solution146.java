package com.charlie.leetcode.linkedlist;

import java.util.LinkedHashMap;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/2/15 11:26
 * @Description: LRU(Least Recently Used)
 * 思路：通过双向链表确定 最近使用 和 最少使用
 *
 * 每次查询/插入时先删除key，是为了将最近使用更新到 双向链表的尾部
 */
class Solution146 {
    private final int capacity;
    private final LinkedHashMap<Integer, Integer> cache;    // 自带双向链表

    public Solution146(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<>(capacity);
    }

    public int get(int key) {
        // 删除 key，并利用返回值判断 key 是否在 cache 中
        Integer value = cache.remove(key);
        if (value != null) {        // key 在 cache 中
            cache.put(key, value);  // 把 key 移动到链表尾部
            return value;
        }
        // key 不在 cache 中
        return -1;
    }

    public void put(int key, int value) {
        // 删除 key，并利用返回值判断 key 是否在 cache 中
        if (cache.remove(key) != null) {    // key 在 cache 中
            cache.put(key, value);          // 把 key 移动到链表尾部
            return;
        }
        // key 不在 cache 中，那么就把 key 插入 cache，插入前判断 cache 是否满了
        if (cache.size() == capacity) { // cache 满了
            Integer oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);    // 移除最久未使用的 key
        }
        cache.put(key, value);
    }

}
