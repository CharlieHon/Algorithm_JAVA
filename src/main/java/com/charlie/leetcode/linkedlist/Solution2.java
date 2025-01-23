package com.charlie.leetcode.linkedlist;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/1/23 13:31
 * @Description: 两数相加
 */
class Solution2 {
    // 1. 迭代法
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 哨兵节点，往其后添加节点
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            curr.next = new ListNode(carry % 10);
            carry /= 10;
            curr = curr.next;
        }
        return dummy.next;
    }

    // 2. 递归法
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        return addTwo(l1, l2, 0);
    }

    private ListNode addTwo(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) {
            return carry != 0 ? new ListNode(carry) : null;
        }
        // 保证l1不为null
        if (l1 == null) {
            l1 = l2;
            l2 = null;
        }
        int sum = carry + l1.val + (l2 != null ? l2.val : 0);
        l1.val = sum % 10;
        l1.next = addTwo(l1.next, (l2 != null ? l2.next : null), sum / 10);
        return l1;
    }
}
