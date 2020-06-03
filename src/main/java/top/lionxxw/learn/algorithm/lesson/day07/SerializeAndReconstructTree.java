package top.lionxxw.learn.algorithm.lesson.day07;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的序列化和反序列化
 * <p>
 *
 * @author wangxiang
 * created on 2020/6/2 19:37
 */
public class SerializeAndReconstructTree {
    /*
     * 二叉树可以通过先序、后序或者按层遍历的方式序列化和反序列化，
     * 以下代码全部实现了。
     * 但是，二叉树无法通过中序遍历的方式实现序列化和反序列化
     * 因为不同的两棵树，可能得到同样的中序序列，即便补了空位置也可能一样。
     * 比如如下两棵树
     *         __2
     *        /
     *       1
     *       和
     *       1__
     *          \
     *           2
     * 补足空位置的中序遍历结果都是{ null, 1, null, 2, null}
     *
     * */
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
        head.left.right = new Node(3);
        Queue<String> prelist = preSerial(head);
        System.out.println("前序序列化结果:" + prelist);
        Node node = buildByPreQueue(prelist);
        boolean comparator = isSameValueStructure(head, node);
        System.out.println(comparator ? "ok" : "fail");
        Queue<String> inlist = inSerial(head);
        System.out.println("中序序列化结果:" + inlist);
        node = buildByInQueue(inlist);
        comparator = isSameValueStructure(head, node);
        System.out.println(comparator ? "ok" : "fail");
        Queue<String> poslist = posSerial(head);
        System.out.println("后序序列化结果:" + poslist);
        node = buildByPosQueue(poslist);
        comparator = isSameValueStructure(head, node);
        System.out.println(comparator ? "ok" : "fail");
        Queue<String> levelist = levelSerial(head);
        System.out.println("层序列化结果:" + levelist);
        node = buildByLevelQueue(levelist);
        comparator = isSameValueStructure(head, node);
        System.out.println(comparator ? "ok" : "fail");
    }

    // for test
    public static boolean isSameValueStructure(Node head1, Node head2) {
        if (head1 == null && head2 != null) {
            return false;
        }
        if (head1 != null && head2 == null) {
            return false;
        }
        if (head1 == null && head2 == null) {
            return true;
        }
        if (head1.value != head2.value) {
            return false;
        }
        return isSameValueStructure(head1.left, head2.left) && isSameValueStructure(head1.right, head2.right);
    }

    // 二叉树前序序列化
    public static Queue<String> preSerial(Node head) {
        Queue<String> ans = new LinkedList<>();
        pres(head, ans);
        return ans;
    }

    private static void pres(Node head, Queue<String> ans) {
        if (head == null) {
            ans.add(null);
        } else {
            ans.add(String.valueOf(head.value));
            pres(head.left, ans);
            pres(head.right, ans);
        }
    }

    // 二叉树前序反序列化
    public static Node buildByPreQueue(Queue<String> prelist) {
        if (prelist == null || prelist.size() == 0) {
            return null;
        }
        return preb(prelist);
    }

    private static Node preb(Queue<String> prelist) {
        String value = prelist.poll();
        if (value == null) {
            return null;
        }
        Node head = new Node(Integer.parseInt(value));
        head.left = preb(prelist);
        head.right = preb(prelist);
        return head;
    }

    // 中序序列化
    public static Queue<String> inSerial(Node head) {
        Queue<String> ans = new LinkedList<>();
        ins(head, ans);
        return ans;
    }

    private static void ins(Node head, Queue<String> ans) {
        if (head == null) {
            ans.add(null);
        } else {
            ins(head.left, ans);
            ans.add(String.valueOf(head.value));
            ins(head.right, ans);
        }
    }

    public static Node buildByInQueue(Queue<String> inlist) {
        if (inlist == null || inlist.size() == 0) {
            return null;
        }
        return inb(inlist);
    }

    private static Node inb(Queue<String> inlist) {
        String value = inlist.poll();
        if (value == null) {
            return null;
        }
        // 先左子树、再头节点、然后右子树<
        Node left = inb(inlist);
        Node head = new Node(Integer.parseInt(value));
        head.left = left;
        head.right = inb(inlist);
        return head;
    }


    // 后序序列化
    public static Queue<String> posSerial(Node head) {
        Queue<String> ans = new LinkedList<>();
        poss(head, ans);
        return ans;
    }

    private static void poss(Node head, Queue<String> ans) {
        if (head == null) {
            ans.add(null);
        } else {
            poss(head.left, ans);
            poss(head.right, ans);
            ans.add(String.valueOf(head.value));
        }
    }

    public static Node buildByPosQueue(Queue<String> poslist) {
        if (poslist == null || poslist.size() == 0) {
            return null;
        }
        Stack<String> stack = new Stack<>();
        while (!poslist.isEmpty()) {
            stack.push(poslist.poll());
        }
        return posb(stack);
    }

    private static Node posb(Stack<String> stack) {
        String value = stack.pop();
        if (value == null) {
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.right = posb(stack);
        head.left = posb(stack);
        return head;
    }

    // 按层序列化
    public static Queue<String> levelSerial(Node head) {
        Queue<String> ans = new LinkedList<>();
        if (head == null) {
            ans.add(null);
        } else {
            ans.add(String.valueOf(head.value));
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(head);
            while (!queue.isEmpty()) {
                head = queue.poll();
                if (head.left == null) {
                    ans.add(null);
                } else {
                    ans.add(String.valueOf(head.left.value));
                    queue.add(head.left);
                }
                if (head.right == null) {
                    ans.add(null);
                } else {
                    ans.add(String.valueOf(head.right.value));
                    queue.add(head.right);
                }
            }
        }
        return ans;
    }

    public static Node buildByLevelQueue(Queue<String> levelList) {
        if (levelList == null || levelList.size() == 0) {
            return null;
        }
        String value = levelList.poll();
        if (value == null){
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Node node;
        while (!queue.isEmpty()){
            node = queue.poll();
            node.left = generateNode(levelList.poll());
            node.right = generateNode(levelList.poll());
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
        return head;
    }

    public static Node generateNode(String val) {
        if (val == null) {
            return null;
        }
        return new Node(Integer.valueOf(val));
    }
}
