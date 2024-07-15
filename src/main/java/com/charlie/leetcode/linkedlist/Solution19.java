package com.charlie.leetcode.linkedlist;

/**
 * <h1>删除链表的倒数第N个节点</h1>
 */
public class Solution19 {

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * <h3>先遍历一遍链表，得到链表长度；再遍历一遍找到要删除的节点的前一个节点</h3>
     *
     * @param head 头结点
     * @param n    要删除倒数第几个节点
     * @return 新头节点
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        int size = 0;

        ListNode last = dummy;
        while (last.next != null) {
            last = last.next;
            size++;
        }

        ListNode pre = dummy;
        for (int i = 0; i < size - n; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;

        return dummy.next;
    }

    /**
     * <h3>快慢指针法</h3>
     *
     * @param head 头结点
     * @param n    要删除倒数第几个节点
     * @return 新头节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode slowNode = dummy, fastNode = dummy;

        // 快指针先往前走n个节点
        for (int i = 0; i < n; i++) {
            fastNode = fastNode.next;
        }

        // 快慢指针同时走，当快指针的下一个为null时，满指针走到要删除的节点之前
        while (fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }

        slowNode.next = slowNode.next.next;
        return dummy.next;
    }

}
