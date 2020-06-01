package top.lionxxw.learn.algorithm.lesson.day07;

/**
 * 二叉树的先序、中序、后序遍历
 * 先序:任何子树的处理顺序都是，先头节点、再左子树、然后右子树<br>
 * 中序:任何子树的处理顺序都是，先左子树、再头节点、然后右子树<br>
 * 后序:任何子树的处理顺序都是，先左子树、再右子树、然后头节点<br>
 * <p>
 *
 * @author wangxiang
 * created on 2020/6/1 14:34
 */
public class RecursiveTraversalBT {

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
        System.out.println("======type=1前序========");
        f(head, 1);
        System.out.println("======type=2中序========");
        f(head, 2);
        System.out.println("======type=3后序========");
        f(head, 3);
    }

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    public static void f(Node head, int type){
        if (head == null){
            return;
        }
        // type = 1 前序打印
        if(type == 1){
            System.out.println(head.value);
        }
        f(head.left, type);
        // type = 2 中序序打印
        if(type == 2){
            System.out.println(head.value);
        }
        f(head.right, type);
        // type = 3 后序打印
        if(type == 3){
            System.out.println(head.value);
        }
    }

    /**
     * 先序:任何子树的处理顺序都是，先头节点、再左子树、然后右子树
     * @param head
     */
    public static void pre(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value);
        pre(head.left);
        pre(head.right);
    }

    /**
     * 中序:任何子树的处理顺序都是，先左子树、再头节点、然后右子树<br>
     * @param head
     */
    public static void in(Node head) {
        if (head == null){
            return;
        }
        in(head.left);
        System.out.println(head.value);
        in(head.right);
    }

    /**
     * 后序:任何子树的处理顺序都是，先左子树、再右子树、然后头节点<br>
     * @param head
     */
    public static void pos(Node head){
        if (head == null){
            return;
        }
        pos(head.left);
        pos(head.right);
        System.out.println(head.value);
    }
}
