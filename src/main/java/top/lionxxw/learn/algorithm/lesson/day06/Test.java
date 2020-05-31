package top.lionxxw.learn.algorithm.lesson.day06;

/**
 * 删除一个对象
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/31 23:00
 */
public class Test {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        a.next = b;
        b.next = c;
        printNode(a);
        // 删除一个节点,这样操作是不行的,只是将c的内存地址更改为null,但是不会影响到原对象
        c = null;
        printNode(a);
        b.next = null;
        printNode(a);
    }

    private static void printNode(Node node){
        Node cur = node;
        while (cur != null){
            System.out.print(cur.value + "->");
            cur = cur.next;
        }
        System.out.println("null");
    }
}
