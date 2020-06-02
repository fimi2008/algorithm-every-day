package top.lionxxw.learn.algorithm.lesson.day07;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 实现二叉树的按层遍历
 * 其实就是宽度优先遍历，用队列
 * <p>
 *
 * @author wangxiang
 * created on 2020/6/2 18:45
 */
public class LevelTraversalBT {

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
        level(head);
    }

    public static void level(Node head) {
        if (head == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Node cur;
        while (!queue.isEmpty()){
            cur = queue.poll();
            System.out.println(cur.value);
            if (cur.left != null){
                queue.add(cur.left);
            }
            if (cur.right != null){
                queue.add(cur.right);
            }
        }
    }

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }
}
