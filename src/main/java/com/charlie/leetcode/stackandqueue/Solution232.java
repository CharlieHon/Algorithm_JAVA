package com.charlie.leetcode.stackandqueue;

import java.util.Stack;

/**
 * <h1>用栈实现队列</h1>
 * 通过两个队列，一个输入栈(stIn)，一个输出栈(stOut)，模拟队列行为
 */
public class Solution232 {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(8);
        myQueue.push(9);
        myQueue.push(5);
        int pop1 = myQueue.pop();
        System.out.println("pop1=" + pop1);
        int peek1 = myQueue.peek();
        System.out.println("peek1=" + peek1);
    }
}

class MyQueue {

    private Stack<Integer> stIn;
    private Stack<Integer> stOut;

    public MyQueue() {
        stIn = new Stack<>();
        stOut = new Stack<>();
    }

    public void push(int x) {
        stIn.push(x);
    }

    public int pop() {
        dumpStackIn();
        return stOut.pop();
    }

    public int peek() {
        dumpStackIn();
        return stOut.peek();
    }

    public boolean empty() {
        return stIn.empty() && stOut.empty();
    }

    // 如果stackOut为空，则姜stackIn中的元素全部访道stackOut中
    public void dumpStackIn() {
        if (!stOut.isEmpty())   return;
        while (!stIn.isEmpty()) {
            stOut.push(stIn.pop());
        }
    }

}
