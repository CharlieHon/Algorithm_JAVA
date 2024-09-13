package com.charlie.datastructure.linkedlist;


/**
 * <h3>反转链表</h3>
 */
public class Solution206 {

    /**
     * 双指针反转链表
     */
    public static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 递归法反转链表
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;    // 最后节点
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;  //
        head.next = null;       // 防止最后2个节点死循环
        return last;
    }

    // 方法5 - 不断把 o1 头插到 n1
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode n1 = null;
        while (head != null) {
            ListNode o1 = head.next;
            head.next = n1;
            n1 = head;
            head = o1;
        }
        return n1;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        print(head);
        head = reverseList(head);
        print(head);
    }

    private static void print(ListNode head) {
        System.out.println("---");
        while (head != null) {
            System.out.printf("%-4d", head.val);
            head = head.next;
        }
        System.out.println();
    }

    private static class ListNode {
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
}
