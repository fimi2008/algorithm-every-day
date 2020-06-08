package top.lionxxw.learn.algorithm.lesson.day07;

/**
 * 寻找一个节点的后继节点(中序遍历的后一个节点)
 * <p>
 *
 * @author wangxiang
 * created on 2020/6/8 16:52
 */
public class SuccessorNode {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(6);
        head.parent = null;
        head.left = new Node(3);
        head.left.parent = head;
        head.left.left = new Node(1);
        head.left.left.parent = head.left;
        head.left.left.right = new Node(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new Node(4);
        head.left.right.parent = head.left;
        head.left.right.right = new Node(5);
        head.left.right.right.parent = head.left.right;
        head.right = new Node(9);
        head.right.parent = head;
        head.right.left = new Node(8);
        head.right.left.parent = head.right;
        head.right.left.left = new Node(7);
        head.right.left.left.parent = head.right.left;
        head.right.right = new Node(10);
        head.right.right.parent = head.right;

        Node test = head.left.left;
        System.out.println(test.value + " next: " + getPosNode(test).value);
        test = head.left.left.right;
        System.out.println(test.value + " next: " + getPosNode(test).value);
        test = head.left;
        System.out.println(test.value + " next: " + getPosNode(test).value);
        test = head.left.right;
        System.out.println(test.value + " next: " + getPosNode(test).value);
        test = head.left.right.right;
        System.out.println(test.value + " next: " + getPosNode(test).value);
        test = head;
        System.out.println(test.value + " next: " + getPosNode(test).value);
        test = head.right.left.left;
        System.out.println(test.value + " next: " + getPosNode(test).value);
        test = head.right.left;
        System.out.println(test.value + " next: " + getPosNode(test).value);
        test = head.right;
        System.out.println(test.value + " next: " + getPosNode(test).value);
        test = head.right.right; // 10's next is null
        System.out.println(test.value + " next: " + getPosNode(test));

        // 前驱节点
        System.out.println(test.value + " pre: " + getPreNode(test).value);
        test = head.left.left.right;
        System.out.println(test.value + " pre: " + getPreNode(test).value);
        test = head.left;
        System.out.println(test.value + " pre: " + getPreNode(test).value);
        test = head.left.right;
        System.out.println(test.value + " pre: " + getPreNode(test).value);
        test = head.left.right.right;
        System.out.println(test.value + " pre: " + getPreNode(test).value);
        test = head;
        System.out.println(test.value + " pre: " + getPreNode(test).value);
        test = head.right.left.left;
        System.out.println(test.value + " pre: " + getPreNode(test).value);
        test = head.right.left;
        System.out.println(test.value + " pre: " + getPreNode(test).value);
        test = head.right;
        System.out.println(test.value + " pre: " + getPreNode(test).value);
        test = head.right.right;
        System.out.println(test.value + " pre: " + getPreNode(test).value);
    }

    /**
     * 寻找一个节点的后继节点(中序遍历的后一个节点)
     * 假设找 x 节点的后继节点
     * 1.x有右子树,找右子树的最左节点
     * 2.x无右子树,找父节点是某一节点的左子树为止
     */
    public static Node getPosNode(Node node) {
        if (node == null) {
            return node;
        }
        //1.x有右子树,找右子树的最左节点
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            //2.x无右子树,找父节点是某一节点的左子树为止
            Node parent = node.parent;
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    /**
     * 寻找一个节点的前驱节点(中序遍历的前一个节点)
     * @param node
     * @return
     */
    public static Node getPreNode(Node node){
        if (node == null) {
            return node;
        }
        // 1.有左节点,找左节点的最右节点
        if (node.left != null){
            node = node.left;
            while (node.right != null){
               node = node.right;
            }
            return node;
        }
        // 2.没有左节点
        else {
            Node parent = node.parent;
            // 2.1 当前节点的父节点是左节点
            if (parent.left == node){
                // 一直找到节点为父节点的非左节点为止
                while (parent != null && parent.left == node){
                    node = parent;
                    parent = node.parent;
                }
               return parent;
            }
            // 2.2 当前节点是父节点的右节点
            else{
                // 上一个父节点就是前驱节点
                return parent;
            }
        }

    }
}
