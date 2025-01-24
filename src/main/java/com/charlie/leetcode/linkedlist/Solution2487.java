package com.charlie.leetcode.linkedlist;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/1/24 18:56
 * @Description: 从链表中移除节点
 * 如果链表中某节点，其右侧中有比该节点值大的节点，则删除该节点
 */
class Solution2487 {
    public ListNode removeNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 递归，递归，先递再归
        ListNode node = removeNodes(head.next);
        if (node.val > head.val) {
            return node;
        }
        head.next = node;
        return head;
    }
}
