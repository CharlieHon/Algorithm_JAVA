package com.charlie.leetcode.stackandqueue;

import java.util.Stack;

/**
 * 中缀表达式转后缀
 */
public class E03InfixToSuffix {

    public static void main(String[] args) {
        //String exp = "(a+b*c-d)*e";     // abc*+d-e*
        String exp = "a*(b+c)";     // abc+*
        String suffix = infixToSuffix(exp);
        System.out.println("suffix=" + suffix);
    }

    private static int priority(char c) {
        return switch (c) {
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            case '(' -> 0;
            default -> throw new IllegalArgumentException("不合法运算符：" + c);
        };
    }

    /**
     * 中缀表达式转成后缀表达式，思路：
     * 1. 遇到非运算符(数值)，直接拼串
     * 2. 遇到 + - * / 运算符
     *  - 它的优先级比栈顶运算符高，就入栈。如：栈顶是+，当前是*
     *  - 否则就栈里优先级 >= 它 的都出栈，它再入栈。比如：栈中是 +*，当前是 /
     * 3. 遍历完成，栈里剩余运算符依次出栈
     * 4. 带 ()
     *  - 左括号直接入栈，左括号优先级设置为0
     *  - 右括号，就把栈里直到左括号为止的所有运算符出栈，在将左括号出栈
     */
    public static String infixToSuffix(String exp) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(exp.length());
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            switch (c) {
                case '+', '-', '*', '/' -> {    // 运算符
                    if (stack.empty() || priority(c) > priority(stack.peek())) {
                        stack.push(c);
                    } else {
                        while (!stack.empty() && priority(c) <= priority(stack.peek())) {
                            sb.append(stack.pop());
                        }
                        stack.push(c);
                    }
                }
                case '(' -> {   // 左括号
                    stack.push(c);
                }
                case ')' -> {   // 右括号
                    while (!stack.empty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();    // 左括号出栈
                }
                default -> {    // 数字符号直接拼接
                    sb.append(c);
                }
            }
        }

        // 把栈里剩下的运算符出栈
        while (!stack.empty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

}
