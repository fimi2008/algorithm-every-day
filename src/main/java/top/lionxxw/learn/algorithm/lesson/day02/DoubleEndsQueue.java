package top.lionxxw.learn.algorithm.lesson.day02;

/**
 * 双向链表
 * 实现栈和队列
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/14 19:41
 */
public class DoubleEndsQueue<T> {

    /**
     * 头指针
     */
    public Node<T> head;
    /**
     * 尾指针
     */
    public Node<T> tail;

    /**
     * 从头部添加数据
     *
     * @param value 数据
     */
    public void addFromHead(T value) {
        Node<T> cur = new Node<>(value);
        if (head == null) {
            head = cur;
            tail = cur;
        } else {
            cur.next = head;
            head.pre = cur;
            head = cur;
        }
    }

    /**
     * 从尾部添加数据
     *
     * @param value 数据
     */
    public void addFromBottom(T value) {
        Node<T> cur = new Node<>(value);
        if (tail == null) {
            tail = cur;
            head = cur;
        } else {
            cur.pre = tail;
            tail.next = cur;
            tail = cur;
        }
    }

    /**
     * 从头部推出元素
     *
     * @return 元素
     */
    public T popFromHead() {
        if (head == null) {
            return null;
        }
        Node<T> cur = head;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            cur.next = null;
            head.pre = null;
        }

        return cur.value;
    }

    /**
     * 从尾部推出元素
     *
     * @return 元素
     */
    public T popFromBottom() {
        if (tail == null) {
            return null;
        }
        Node<T> cur = tail;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.pre;
            cur.pre = null;
            tail.next = null;
        }
        return cur.value;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public static class Node<T> {
        public T value;
        public Node<T> pre;
        public Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    /**
     * 使用双向链表实现栈
     *
     * @param <T>
     */
    public static class MyStack<T> {
        private DoubleEndsQueue<T> queue;

        public MyStack() {
            this.queue = new DoubleEndsQueue<>();
        }

        public void push(T value) {
            queue.addFromHead(value);
        }

        public T pop() {
            return queue.popFromHead();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }

    /**
     * 使用双向链表实现队列
     *
     * @param <T>
     */
    public static class MyQueue<T> {
        private DoubleEndsQueue<T> queue;

        public MyQueue() {
            this.queue = new DoubleEndsQueue<>();
        }

        public void push(T value) {
            queue.addFromHead(value);
        }

        public T pop() {
            return queue.popFromBottom();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }

}
