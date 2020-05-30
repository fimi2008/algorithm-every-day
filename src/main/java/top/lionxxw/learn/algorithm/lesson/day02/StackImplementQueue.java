package top.lionxxw.learn.algorithm.lesson.day02;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

/**
 * 用栈实现队列
 * 实现原理: 2个栈来实现,一个栈为push栈,一个栈为pop栈
 * 队列的特性:先入先出
 * 栈的特性:后入先出
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/15 10:44
 */
public class StackImplementQueue {

    private Deque<Integer> stackPush;
    private Deque<Integer> stackPop;

    public StackImplementQueue() {
        this.stackPush = new ArrayDeque<>();
        this.stackPop = new ArrayDeque<>();
    }

    public void add(int value){
        stackPush.push(value);
        pushToPop();
    }

    public int poll(){
        if (stackPop.isEmpty() && stackPush.isEmpty()){
            throw new RuntimeException("queue is empty");
        }
        pushToPop();
        return stackPop.pop();
    }

    public int peek(){
        if (stackPop.isEmpty() && stackPush.isEmpty()){
            throw new RuntimeException("queue is empty");
        }
        pushToPop();
        return stackPop.peek();
    }

    /**
     * 将push栈的数据转换到pop栈中
     */
    private void pushToPop(){
        // 前提必须是pop栈为空,不然顺序不一致
        if(stackPop.isEmpty()){
            // 必须将push栈的数据全部倒空
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
    }

    public static void main(String[] args) {
        StackImplementQueue queue = new StackImplementQueue();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            System.out.println("输入命令:add|pop|peek|quit");
            String command = scanner.next();
            switch (command){
                case "add":
                    System.out.println("输入值:");
                    int num = scanner.nextInt();
                    queue.add(num);
                    break;
                case "pop":
                    System.out.println("pop的值:"+queue.poll());
                    break;
                case "peek":
                    System.out.println("peek的值:"+queue.peek());
                    break;
                case "quit":
                    flag = false;
                    System.out.println("程序退出");
                    break;
                default:
                    System.out.println("支持命令为:add|pop|peek|quit");
            }
        }
    }
}
