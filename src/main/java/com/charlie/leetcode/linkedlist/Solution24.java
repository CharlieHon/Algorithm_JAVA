package com.charlie.leetcode.linkedlist;

/**
 * <h1>两两交换链表中的节点</h1>
 */
public class Solution24 {

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * <h3>直接依次两两交换值</h3>
     * @param head 链表头结点
     * @return 结果头结点
     */
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy.next;
        ListNode curr = pre.next;
        while (curr != null) {
            int tmp = pre.val;
            pre.val = curr.val;
            curr.val = tmp;
            pre = curr.next;
            if (pre != null) {
                curr = pre.next;
            } else {
                break;
            }
        }
        return dummy.next;
    }

    public ListNode swapPairs(ListNode head) {
        //if (head == null || head.next == null) {
        //    return head;
        //}

        ListNode dummy = new ListNode(-1, head);
        ListNode curr = dummy;
        ListNode tmp;   // 临时节点，保存两个节点后面的节点
        ListNode firstNode;
        ListNode secondNode;

        while (curr.next != null && curr.next.next != null) {
            tmp = curr.next.next.next;
            firstNode = curr.next;
            secondNode = curr.next.next;
            curr.next = secondNode;
            secondNode.next = firstNode;
            firstNode.next = tmp;
            curr = firstNode;
        }

        return dummy.next;
    }

    /**
     * <h3>两两交换链表中的节点</h3>
     * @param head 原链表头节点
     * @return 两两交换后链表头结点
     */
    public ListNode swapPairs_recursion(ListNode head) {
        // 边界条件，两两交换的前提是至少还剩下倆节点
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        // 递归解决后面节点的交换，并将交换后返回的节点赋值给head
        head.next = swapPairs_recursion(next.next);
        // next下一个指向head，将前两个完成交换
        next.next = head;
        return next;    // 返回新新头结点
    }

}
