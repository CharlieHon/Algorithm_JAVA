package com.charlie.leetcode.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/2/15 10:18
 * @Description: 合并K个升序链表
 */
class Solution23 {

    // 最小堆：因为每个链表都是升序排序，最小的节点是所有链表头结点的最小值，第二小的是该节点的下一个节点或者其它头结点
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }

        ListNode dummy = new ListNode();
        ListNode pre = dummy;
        while (!pq.isEmpty()) {
            ListNode cur = pq.poll();
            if (cur.next != null) {
                pq.offer(cur.next);
            }
            pre.next = cur;
            pre = pre.next;
        }
        return dummy.next;
    }

    // 分治
    public ListNode mergeKLists2(ListNode[] lists) {
        return mergeKLists2(lists, 0, lists.length);
    }

    private ListNode mergeKLists2(ListNode[] lists, int i, int j) {
        int m = j - i;
        if (m == 0) {
            return null;
        } else if (m == 1) {
            return lists[i];    // i
        }

        ListNode left = mergeKLists2(lists, i, i + m / 2);
        ListNode right = mergeKLists2(lists, i + m / 2, j);
        return mergeTwoLists(left, right);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode pre = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 != null ? l1 : l2;
        return dummy.next;
    }
}
