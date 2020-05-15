package top.lionxxw.learn.algorithm.lesson.day02;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/15 11:05
 */
public class QueueImplementStack {
    private Queue<Integer> queueData;
    private Queue<Integer> queueHelp;
    private int top;

    public void push(int x) {
        queueData.add(x);
        this.top = x;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (queueData.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        while (queueData.size() > 1) {
            top = queueData.poll();
            queueHelp.add(top);
        }
        Integer val = queueData.poll();
        Queue<Integer> temp = queueHelp;
        queueHelp = queueData;
        queueData = temp;
        return val;
    }

    /**
     * Get the top element.
     */
    public int top() {
        return top;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queueData.isEmpty() ;
    }

    public QueueImplementStack() {
        this.queueData = new LinkedList<>();
        this.queueHelp = new LinkedList<>();
    }

    public static void main(String[] args) {
        QueueImplementStack stack = new QueueImplementStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.empty());
    }
}
