package top.lionxxw.learn.algorithm.lesson.day07;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 非递归实现二叉树的前序,中序,后序
 * <p>
 *
 * @author wangxiang
 * created on 2020/6/1 15:53
 */
public class UnRecursiveTraversalBT {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        Node left = head.left;
        left.left = new Node(4);
        left.right = new Node(5);
        Node right = head.right;
        right.left = new Node(6);
        right.right = new Node(7);
        /*
         *      1
         *     /  \
         *   2     3
         *  / \   / \
         * 4  5  6   7
         */
        System.out.println("======前序========");
        pre(head);
        System.out.println("======中序========");
        in(head);
        System.out.println("======后序========");
        pos(head);
        System.out.println("======后序2========");
        pos2(head);
    }

    /**
     * 先序:任何子树的处理顺序都是，先头节点、再左子树、然后右子树<br>
     */
    public static void pre(Node head) {
        if (head == null) {
            return;
        }
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.println(head.value);
            if (head.right != null) {
                stack.push(head.right);
            }
            if (head.left != null) {
                stack.push(head.left);
            }
        }
    }

    /**
     * 中序:任何子树的处理顺序都是，先左子树、再头节点、然后右子树<br>
     */
    public static void in(Node head) {
        if (head == null) {
            return;
        }
        Deque<Node> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || head != null) {
            // 1.整条左边界依次入栈
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                // 2.条件1无法成立,弹出,切换到右节点,执行1
                head = stack.pop();
                System.out.println(head.value);
                head = head.right;
            }
        }
    }

    /**
     * 后序:任何子树的处理顺序都是，先左子树、再右子树、然后头节点
     * 将前序替换下right和left的入栈顺序,倒序输出就是后序
     */
    public static void pos(Node head) {
        if (head == null) {
            return;
        }
        Deque<Node> stack = new ArrayDeque<>();
        Deque<Node> res = new ArrayDeque<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            res.push(head);
            if (head.left != null) {
                stack.push(head.left);
            }
            if (head.right != null) {
                stack.push(head.right);
            }
        }
        while (!res.isEmpty()) {
            System.out.println(res.pop().value);
        }
    }

    /**
     * 后序:任何子树的处理顺序都是，先左子树、再右子树、然后头节点
     */
    public static void pos2(Node head) {
        if (head == null) {
            return;
        }
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(head);
        // 辅助节点,判断是否为当前节点的左或右子节点
        Node c;
        while (!stack.isEmpty()) {
            c = stack.peek();
            if (c.left != null && head != c.left && head != c.right) {
                stack.push(c.left);
            } else if (c.right != null && head != c.right) {
                stack.push(c.right);
            } else {
                System.out.println(stack.pop().value);
                head = c;
            }
        }
    }
}
