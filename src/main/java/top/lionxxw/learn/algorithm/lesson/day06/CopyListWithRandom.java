package top.lionxxw.learn.algorithm.lesson.day06;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 一种特殊的单链表节点类描述如下
 * class Node {
 * int value;
 * Node next;
 * Node rand;
 * Node(int val) {value = val; }
 * }
 * rand指针是单链表节点结构中新增的指针，rand可能指向链表中的任意一个节点，也可能指向null。
 * 给定一个由Node节点类型组成的无环单链表的头节点head,请实现-个函数完成这 个链表的复制，并返回复制的新链表的头节点。
 * [要求]
 * 时间复杂度O(N)，额外空间复杂度0(1)
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/31 11:45
 */
public class CopyListWithRandom {

    public static void main(String[] args) {
        int num = 10;
        Node head = new Node(0);
        Node cur = head;
        Map<Integer, Node> map = new HashMap<>(num);

        for (int i = 1; i < num; i++) {
            cur.next = new Node(i);
            if (i == 1) {
                map.put(0, cur);
            }
            map.put(i, cur);
            cur = cur.next;
        }
        Random random = new Random();
        cur = head;
        while (cur != null) {
            int i = random.nextInt(num);
            cur.rand = map.get(i);
            cur = cur.next;
        }
        System.out.println(head);
        Node copy1 = copyListWithRand1(head);
        System.out.println(isEquals(head, copy1));
        Node copy2 = copyListWithRand2(head);
        System.out.println(isEquals(head, copy2));
    }

    private static boolean isEquals(Node head, Node copy1) {
        Node cur = head;
        Node curCopy = copy1;
        while (cur != null){
            if (cur.value != curCopy.value){
                return false;
            }
            if (cur.rand.value != curCopy.rand.value){
                return false;
            }
            cur = cur.next;
            curCopy = curCopy.next;
        }
        return true;
    }

    public static class Node {
        int value;
        Node next;
        Node rand;

        Node(int val) {
            value = val;
        }
    }

    /**
     * 基于map实现链表的复制
     * 时间复杂度:O(N)
     * 空间复杂度:O(N)
     */
    public static Node copyListWithRand1(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        // 将所有克隆的节点,存放在map中,建立老的node和克隆节点的对应关系
        while (cur != null) {
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            // 将克隆节点的下一个节点指向当前节点的下一个克隆节点
            map.get(cur).next = map.get(cur.next);
            // 将克隆节点的rand节点指向当前节点的rand克隆节点
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    /**
     * 时间复杂度:O(N)
     * 空间复杂度:O(1)
     */
    public static Node copyListWithRand2(Node head) {
        Node cur = head;
        Node next;
        while (cur != null) {
            next = cur.next;
            // 在节点1->2之间插入克隆节点1->1`->2
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        Node copyNode;
        while (cur != null) {
            next = cur.next.next;
            copyNode = cur.next;
            // 将克隆节点的rand指向对应的克隆节点
            copyNode.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }
        // 分离节点和克隆节点
        Node res = head.next;
        cur = head;
        while (cur != null) {
            next = cur.next.next;
            copyNode = cur.next;
            cur.next = next;
            copyNode.next = next != null ? next.next : null;;
            cur = next;
        }
        return res;
    }
}
