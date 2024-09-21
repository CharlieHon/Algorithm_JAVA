package com.charlie.leetcode.treenode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class TravelsalIter {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(
                new TreeNode(
                        new TreeNode(1),
                        4,
                        new TreeNode(2)
                ),
                5,
                new TreeNode(
                        new TreeNode(7),
                        6,
                        new TreeNode(8)
                )
        );

        //List<Integer> res = test1(node);
        //List<Integer> res = test2(node);
        List<Integer> res = test3(node);
        System.out.println("res=" + res);

    }

    /**
     * 递归的实现就是：每一次递归调用都会把函数的局部变量、参数值和返回地址等压入调用栈中，然后递归返回的时候，从栈顶弹出上一次递归的各项参数
     * <p>可以使用栈存储节点，实现二叉树的迭代遍历</p>
     */
    public static List<Integer> test1(TreeNode root) {
        List<Integer> result = new ArrayList<>(100);
        if (root == null) {
            return result;
        }
        // 使用栈存储节点
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode curr = st.pop();
            result.add(curr.val);
            if (curr.right != null) {
                st.push(curr.right);
            }
            if (curr.left != null) {
                st.push(curr.left);
            }
        }
        return result;
    }

    // 迭代-中序遍历
    public static List<Integer> test2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !st.isEmpty()) {
            if (curr != null) { // curr指针访问节点，访问到最底层
                st.push(curr);  // 将访问节点放入栈
                curr = curr.left;   // 左
            } else {
                curr = st.pop();    // 从栈里弹出数据，就是要处理的数据，放入result结果
                result.add(curr.val);   // 中
                curr = curr.right;      // 右
            }
        }
        return result;
    }

    // 后序遍历：中左右(前序)->中右左(交换入栈顺序)-反转->左右中
    public static List<Integer> test3(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode curr = st.pop();
            result.add(curr.val);
            if (curr.left != null) {
                st.push(curr.left);
            }
            if (curr.right != null) {
                st.push(curr.right);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
