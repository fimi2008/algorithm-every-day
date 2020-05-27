package top.lionxxw.learn.algorithm.lesson.day04;

import top.lionxxw.learn.algorithm.lesson.day01.BaseClass;


/**
 * TODO
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/25 23:06
 */
public class Heap extends BaseClass {

    private int[] heap;
    private int heapSize = 0;
    private int limit;

    public void push(int value) {
        if (heapSize == limit) {
            throw new RuntimeException("heap is full");
        }
        heap[heapSize] = value;
        heapInsert(heap, heapSize);
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
            // 1.有右孩子,2.有孩子比做孩子大
            int largest = left + 1 < heapSize && heap[left + 1] > heap[left] ? left + 1 : left;
            // 子树节点比根节点大
            largest = heap[largest] > heap[index] ? largest : index;
            if (largest == index){
                break;
            }
            swap(heap, index, largest);
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
