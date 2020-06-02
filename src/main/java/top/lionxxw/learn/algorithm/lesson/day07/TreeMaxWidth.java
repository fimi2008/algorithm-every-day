package top.lionxxw.learn.algorithm.lesson.day07;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 二叉树的最大宽度
 * <p>
 *
 * @author wangxiang
 * created on 2020/6/2 18:51
 */
public class TreeMaxWidth {
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
        System.out.println("最大宽度:" + maxWidthNoMap(head));
        System.out.println("最大宽度:" + maxWidthUseMap(head));
    }

    public static int maxWidthUseMap(Node head) {
        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Node cur;
        int max = 0;
        // 当前你正在统计哪一层的宽度
        int curLevel = 1;
        // 当前层curLevel层，宽度目前是多少
        int curLevelNodes = 0;
        Map<Node, Integer> map = new HashMap<>();
        map.put(head, curLevel);
        int curNodeLevel;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            curNodeLevel = map.get(cur);
            if (cur.left != null) {
                map.put(cur.left, curNodeLevel + 1);
                queue.add(cur.left);
            }
            if (cur.right != null) {
                map.put(cur.right, curNodeLevel + 1);
                queue.add(cur.right);
            }
            // 统计相同层的节点数
            if (curNodeLevel == curLevel){
                curLevelNodes++;
            }else{
                // 进入下一层
                max =Math.max(max, curLevelNodes);
                curLevel++;
                curLevelNodes = 1;
            }
        }
        // 最后一层比较
        max = Math.max(max, curLevelNodes);
        return max;
    }

    public static int maxWidthNoMap(Node head) {
        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Node cur;
        // 当前层的节点数
        int curLevelNodeNums = 0;
        int max = 0;
        // 当前层，最右节点是谁
        Node curEndNode = head;
        // 下一层，最右节点是谁
        Node nextEndNode = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur.left != null) {
                queue.add(cur.left);
                nextEndNode = cur.left;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nextEndNode = cur.right;
            }
            curLevelNodeNums++;
            if (cur == curEndNode) {
                max = Math.max(max, curLevelNodeNums);
                curEndNode = nextEndNode;
                curLevelNodeNums = 0;
            }
        }
        return max;
    }
}
