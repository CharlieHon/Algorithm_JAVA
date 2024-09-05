package com.charlie.leetcode.stackandqueue;

import java.util.LinkedList;

/**
 * <h1>逆波兰表达式求值</h1>
 */
public class Solution120 {
    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        int result = evalRPN(tokens);
        System.out.println("result=" + result);
    }

    public static int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();

        for (String t : tokens) {
            Integer a, b;
            switch (t) {
                case "+":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a + b);
                    break;
                case "-":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a - b);
                    break;
                case "*":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a * b);
                    break;
                case "/":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a / b);
                    break;
                default:
                    stack.push(Integer.parseInt(t));
                    break;
            }
        }
        return stack.pop();
    }

}
