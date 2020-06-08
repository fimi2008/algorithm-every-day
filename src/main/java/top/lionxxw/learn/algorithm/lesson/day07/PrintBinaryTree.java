package top.lionxxw.learn.algorithm.lesson.day07;

/**
 * 如何设计一个打印整棵树的打印函数
 * <p>
 *
 * @author wangxiang
 * created on 2020/6/8 16:12
 */
public class PrintBinaryTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
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
        right.right.right = new Node(11);
        printTree(head);
    }

    public static void printTree(Node head) {
        System.out.println("开始打印二叉树.....");
        printInOrder(head, 0, "H", 10);
        System.out.println("打印完成");
    }

    private static void printInOrder(Node head, int level, String to, int len) {
        if (head == null) {
            return;
        }
        // 先打印右节点
        printInOrder(head.right, level + 1, "R", len);
        // 计算打印的格式
        String val = to + head.value + to;
        int lenM = val.length();
        int lLen = (len - lenM) / 2;
        int rLen = len - -lenM - lLen;
        val = getSpace(lLen) + val + getSpace(rLen);
        System.out.println(getSpace(len * level) + val);
        printInOrder(head.left, level + 1, "L", len);
    }

    private static String getSpace(int num) {
        String space = " ";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(space);
        }
        return sb.toString();
    }
}
