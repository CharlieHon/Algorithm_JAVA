package com.charlie.leetcode.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <h1>用队列实现栈</h1>
 *
 */
public class Solution225 {
}

class MyStack {

    private Queue<Integer> q1;  // 存放与栈相同元素的队列
    private Queue<Integer> q2;  // 辅助队列

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        // 先将q1的元素全部放入q2
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        // 向q1添加元素
        q1.offer(x);
        // 再将q2中元素压回q1
        while (!q2.isEmpty()) {
            q1.offer(q2.poll());
        }
    }

    public int pop() {
        return q1.poll();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
