package com.charlie.leetcode.stackandqueue;

import com.charlie.datastructure.stack.ArrayStack;


/**
 * <h1>有效的括号</h1>
 */
public class Solution20 {

    public static void main(String[] args) {
        String s = "(([{}])";
        System.out.println("isValid=" + isValid(s));
    }

    /**
     * 括号无效分为三种情况：
     * 1. 不匹配
     * 2. 多左括号
     * 3. 多右括号
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        ArrayStack<Character> stack = new ArrayStack<>(s.length());

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else {
                // 当栈已空或者栈顶元素不配对时，
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }

        // 最后需要判空
        return stack.isEmpty();
    }

}
