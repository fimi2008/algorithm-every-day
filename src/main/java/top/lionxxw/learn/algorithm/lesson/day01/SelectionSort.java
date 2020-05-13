package top.lionxxw.learn.algorithm.lesson.day01;

import java.util.Arrays;

/**
 * 选择排序
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/13 15:49
 */
public class SelectionSort extends BaseClass {

    public static void main(String[] args) {
        int[] arr1 = {4, 3, 2, 1};
        int[] arr2 = {4, 3, 2, 1};
        selectionSort(arr1);
        System.out.println(Arrays.toString(arr1));
        comparator(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    /**
     * 第1次:N-1
     * 第2次:N-2
     * 第3次:N-3
     * ...
     * 得出时间复杂度: (N-1)+(N-2)+(N-3)+...+1 = 0.5*N^2 - 0.5*N = O(N^2)
     * 从小到大排序
     *
     * @param arr 无序数组
     */
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int len = arr.length;
        // i ~ N-1
        for (int i = 0; i < len - 1; i++) {
            // i+1 ~ N
            for (int j = i + 1; j < len; j++) {
                // 记录最小元素的下标
                int minIndex = arr[j] < arr[i] ? j : i;
                if (minIndex != i) {
                    swap(arr, i, minIndex);
                }
            }
        }
    }
}