package com.charlie.leetcode.linkedlist;

/**
 * <h1>移除链表元素</h1>
 * 题意：删除链表中等于给定值 val 的所有节点
 */
public class Solution203 {

    // Definition for singly-linked list.
    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * <h3>无虚拟头结点版</h3>
     * 删除头节点和其他节点操作逻辑不同，需要分开操作
     * @param head 链表头
     * @param val 要删除的值
     * @return 新链表头
     */
    public ListNode removeElements2(ListNode head, int val) {
        // 删除头结点
        while (head != null && head.val == val) {
            head = head.next;
        }

        // 删除其它节点
        ListNode curr = head;   // curr不会是目标值
        while (curr != null && curr.next != null) { // 删除节点逻辑，要判断两个节点是否为空
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    /**
     * <h3>设置一个旭倪头结点再进行移除节点操作</h3>
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1, head);
        ListNode curr = dummy;  // curr不会是目标值
        while (curr.next != null) { // curr不可能为null
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }

}
