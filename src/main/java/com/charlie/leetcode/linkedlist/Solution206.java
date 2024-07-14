package com.charlie.leetcode.linkedlist;

/**
 * <h1>反转链表</h1>
 */
public class Solution206 {

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * <h3>递归法</h3>
     * @param head 链表原头结点
     * @return 反转后链表头结点
     */
    public ListNode reverseList2(ListNode head) {
        return reverse(null, head);
    }

    public ListNode reverse(ListNode pre, ListNode curr) {
        if (curr == null) {
            return pre;
        }
        ListNode tmp = curr.next;   // 保存下一个节点
        curr.next = pre;            // 反转
        return reverse(curr, tmp);
    }

    /**
     * <h3>反转链表</h3>
     * 首先定义一个pre指针，初始化为null，即反转后链表结尾；再定义一个curr节点，指向头结点</p>
     * 反转前首先要把curr.next节点用tmp指针保存下来，然后就要改变curr.next的指向，将curr.next指向pre，此时就反转了第一个节点</p>
     * @param head 链表原头结点
     * @return 反转后链表头结点
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        return pre;
    }

}
