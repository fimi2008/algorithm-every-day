package top.lionxxw.learn.algorithm.lesson.day06;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定两个可能有环也可能无环的单链表，头节点head1和head2。
 * 请实现一个函数，如果两个链表相交，请返回相交的第一个节点。
 * 如果不相交，返回null
 * [要求]
 * 如果两个链表长度之和为N，时间复杂度请达到O(N)，额外空间复
 * 杂度请达到O(1)。
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/31 16:00
 */
public class FindFirstIntersectNode {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println("node1=" + getIntersectNode(head1, head2).value);
        System.out.println("node2=" + getIntersectNode2(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println("node1=" + getIntersectNode(head1, head2).value);
        System.out.println("node2=" + getIntersectNode2(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println("node1=" + getIntersectNode(head1, head2).value);
        System.out.println("node2=" + getIntersectNode2(head1, head2).value);
    }

    public static Node getIntersectNode2(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }
        // 一个链表有环,一个链表无环,则肯定没有交点
        return null;
    }

    /**
     * 如果两个链表都无环，返回第一个相交节点，如果不想交，返回null
     */
    public static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        // 如果结尾不是同一个节点,则两个链表没有交点
        if (cur1 != cur2) {
            return null;
        }
        // 链表长的为cur1,短的为cur2
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);
        // 长的cur1先遍历n个节点
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    /**
     * 两个有环链表，返回第一个相交节点，如果不想交返回null
     */
    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        /**
         * 三种情况:
         * 1.两个链表的环不相交
         * 2.两个链表同用一个环,并且同一个入环节口
         * 3.两个链表同用一个环,但是入环节口非同一个
         */
        // 情况2.两个链表同用一个环,并且同一个入环节口
        if (loop1 == loop2) {
            Node cur1 = head1;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            Node cur2 = head2;
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            Node cur = loop1.next;
            while (cur != loop1) {
                // 3.两个链表同用一个环,但是入环节口非同一个
                if (cur == loop2) {
                    return cur;
                }
                cur = cur.next;
            }
            // 1.两个链表的环不相交,链表的环遍历完,还未匹配到另一个链表的入环节点
            return null;
        }
    }

    /**
     * 找到链表第一个入环节点，如果无环，返回null
     *
     * @param head
     * @return
     */
    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


    public static Node getIntersectNode(Node head1, Node head2) {
        Set<Node> set = new HashSet<>();
        Node cur = head1;
        while (cur != null) {
            if (!set.add(cur)) {
                // 环形节点
                break;
            }
            cur = cur.next;
        }
        cur = head2;
        Set<Node> set2 = new HashSet<>();
        while (cur != null) {
            //
            if (set.contains(cur)) {
                return cur;
            }
            if (!set2.add(cur)) {
                // 环形节点
                break;
            }
            cur = cur.next;
        }
        return null;
    }
}
