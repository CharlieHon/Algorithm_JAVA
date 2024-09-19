package com.charlie.leetcode.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <h3>简化路径</h3>
 * <lo>
 *     <li>
 *         输入：path="/home/"
 *     </li>
 *     <li>
 *         输出："/home"
 *     </li>
 * </lo>
 * <lo>
 *     <li>
 *         输入：path="/home/user/Documents/../Pictures"
 *     </li>
 *     <li>
 *         输出："/home/user/Pictures"
 *     </li>
 * </lo>
 */
public class Solution71 {

    public static String simplifyPath(String path) {
        // 使用双端队列，从两端添加和删除
        Deque<String> deque = new ArrayDeque<>();   // 队列中进保存有效文件/目录名称，不保留 '.', '..', '/'
        int n = path.length();
        for (int i = 0; i < n; ) {
            char c = path.charAt(i);
            if (c == '/') { // 直接掠过
                i++;
                continue;
            }
            int j = i + 1;  // [i, j) 表示有效范围
            while (j < n && path.charAt(j) != '/') {
                j++;
            }
            String item = path.substring(i, j);
            if ("..".equals(item)) {    // '..'表示上级目录，则弹出队尾元素(如果队列非空)
                if (!deque.isEmpty()) {
                    deque.pollLast();
                }
            } else if (!".".equals(item)) { // 其它非 '.' 有效内容，均入队
                deque.offerLast(item);
            }
            i = j + 1;  // 此时 j == n 或者 j指向'/'
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append("/" + deque.pollFirst());
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }

    public static void main(String[] args) {
        //String path = "/home//foo/";    // [, home, , foo]
        String path = "/home/user/Documents/../Pictures";    // [, home, user, Documents, .., Pictures]
        //String path = "/../";    // [, ..]
        //String[] split = path.split("/");
        //System.out.println("split=" + Arrays.toString(split));
        String simplified = simplifyPath(path);
        System.out.println("origin=" + path);
        System.out.println("simplified=" + simplified);
    }

}
