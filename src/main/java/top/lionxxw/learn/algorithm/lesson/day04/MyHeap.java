package top.lionxxw.learn.algorithm.lesson.day04;

import top.lionxxw.learn.algorithm.lesson.day01.BaseClass;

import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * 堆结构
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/25 23:06
 */
public class MyHeap extends BaseClass {

    public static void main(String[] args) {
        /**
         * 系统堆默认是小根堆
         */
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {

            /**
             *  返回负数的时候，第一个参数排在前面
             * 	返回正数的时候，第二个参数排在前面
             * 	返回0的时候，谁在前面无所谓
             * 	传入比较强,将系统堆转为大根堆
             */
            @Override
            public int compare(Integer o1, Integer o2) {
//                if (o1 > o2) {
//                    return -1;
//                }
                return o2 - o1;
            }
        });
        heap.add(6);
        heap.add(4);
        heap.add(5);
        heap.add(5);
        heap.add(9);
        heap.add(1);
        heap.add(2);
        while (!heap.isEmpty()) {
            System.out.println(heap.poll());
        }

        System.out.println("==================");
        MyHeap myHeap = new MyHeap(10);
        myHeap.push(6);
        myHeap.push(4);
        myHeap.push(5);
        myHeap.push(5);
        myHeap.push(9);
        myHeap.push(1);
        myHeap.push(2);
        while (!myHeap.isEmpty()) {
            System.out.println(myHeap.pop());
        }

    }

    private int[] heap;
    private int heapSize;
    private int limit;

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public boolean isFull() {
        return heapSize == limit;
    }

    public MyHeap(int limit) {
        this.limit = limit;
        this.heapSize = 0;
        this.heap = new int[limit];
    }

    public void push(int value) {
        if (heapSize == limit) {
            throw new RuntimeException("heap is full");
        }
        heap[heapSize] = value;
        heapInsert(heap, heapSize++);
    }

    public int pop() {
        int res = heap[0];
        swap(heap, 0, --heapSize);
        heapify(heap, 0, heapSize);
        return res;
    }

    private void heapify(int[] heap, int index, int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            // 1.有右孩子,2.右孩子比左孩子大
            int largest = left + 1 < heapSize && heap[left + 1] > heap[left] ? left + 1 : left;
            // 子树节点比根节点大
            largest = heap[largest] > heap[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(heap, largest, index);
            index = largest;
            left = 2 * index + 1;
        }
    }

    private void heapInsert(int[] heap, int index) {
        while (heap[index] > heap[(index - 1) / 2]) {
            swap(heap, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }


}
