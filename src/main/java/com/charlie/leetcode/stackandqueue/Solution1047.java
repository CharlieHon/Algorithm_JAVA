package com.charlie.leetcode.stackandqueue;

import java.util.LinkedList;

/**
 * <h1>删除字符串中的所有相邻重复项</h1>
 */
public class Solution1047 {
    public static void main(String[] args) {
        String s = "abbaca";
        String removeDuplicates = removeDuplicates(s);
        System.out.println("result=" + removeDuplicates);
    }

    public static String removeDuplicates(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }

        String result = "";
        for (Character c : stack) {
            result = c + result;
        }
        return result;
    }

}
